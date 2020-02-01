package com.idsoft.firebase_title.cloudstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.idsoft.firebase_title.R;

import java.io.File;
import java.io.IOException;

public class DowloadActivity extends AppCompatActivity implements View.OnClickListener {


    private File localFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dowload);


        Button localfilednbtn = findViewById(R.id.localbtn);

        localfilednbtn.setOnClickListener(this);

        Button uibtn = findViewById(R.id.uibtn);

        uibtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.localbtn:
                showdown();
                break;

            case R.id.uibtn:
                uidown();
                break;


        }

    }


    private void showdown() {
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference = storage.getReference();

        StorageReference pathReference = storageReference.child("storage/20181013_115822.jpg");

        try {
            localFile = File.createTempFile("images", "jpg"); // 임시파일 생성
            //java.io 패키지는 기존의 파일이나 폴더에 대한 제어를 하는 데 사용하는 File 클래스를 제공한다. 이 클래스를 이용해서 파일과 폴더에 대한 다양한 기능을 제공한다.
        } catch (IOException e) {
            e.printStackTrace();
        }

        pathReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                long filesize = taskSnapshot.getTotalByteCount();
                Log.d("namjinha", "File Size = " + filesize);
                Log.d("namjinha", "File Name = " + localFile.getAbsolutePath());

                ImageView imageView = findViewById(R.id.imageView2);
                Glide.with(DowloadActivity.this).load(new File(localFile.getAbsolutePath())).into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("namjinha", "onFailure in");

            }
        });

    }


    private void uidown() {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();
        StorageReference pathReference = storageReference.child("storage/20181013_115822.jpg");

        ImageView imageView = findViewById(R.id.imageView2);

        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(pathReference)
                .into(imageView);

    }
}
