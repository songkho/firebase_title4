package com.idsoft.firebase_title.realtimedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idsoft.firebase_title.R;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

    private Context context = null;
    private ArrayList<MemoItem> memoItems = null;
    private MemoViewListener memoViewListener = null;


    public MemoAdapter(ArrayList<MemoItem> items,  Context context, MemoViewListener listener ) {

        this.memoItems = items;
        this.context = context;
        this.memoViewListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_memo_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.titleView.setText(memoItems.get(i).getMemotitle());
        viewHolder.contentsView.setText(memoItems.get(i).getMemocontents());


    }

    @Override
    public int getItemCount() {
        return memoItems.size();
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
            memoViewListener.onItemClick(getAdapterPosition(), view);
        }
    }
}