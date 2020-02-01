package com.idsoft.firebase_title.cloudstorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idsoft.firebase_title.R;

import java.util.ArrayList;

public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.ViewHolder> {

    private Context context = null;
    private ArrayList<UploadInfo> imageItems = null;

    public FileListAdapter(ArrayList<UploadInfo> items, Context context){

        this.imageItems = items;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_file_list, viewGroup,false);

        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int i) {

        viewholder.titleView.setText(imageItems.get(i).getName());
        viewholder.contentsView.setText(imageItems.get(i).getPath());

    }

    @Override
    public int getItemCount() {
        return imageItems.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleView = null;
        public TextView contentsView = null;

        public ViewHolder(@NonNull View view) {
            super(view);
            titleView = view.findViewById(R.id.memotitle);
            titleView = view.findViewById(R.id.memocontents);
        }

        @Override
        public void onClick(View view) {
            ;
        }
    }
}
