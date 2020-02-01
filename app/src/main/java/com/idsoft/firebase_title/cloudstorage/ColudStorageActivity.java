package com.idsoft.firebase_title.cloudstorage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.idsoft.firebase_title.R;

public class ColudStorageActivity extends AppCompatActivity implements View.OnClickListener {


    private final int REQUEST_CODE = 100;

    private Button uploadbtn;
    private Button downloadbtn;
    private Button metainfobtn;
    private Button deletebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colud_storage);


        uploadbtn = findViewById(R.id.uploadbtn);
        uploadbtn.setOnClickListener(this);

        downloadbtn = findViewById(R.id.downloadbtn);
        downloadbtn.setOnClickListener(this);

        metainfobtn = findViewById(R.id.metainfobtn);
        metainfobtn.setOnClickListener(this);

        deletebtn = findViewById(R.id.deletebtn);
        deletebtn.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
                Toast.makeText(this, "안드로이드 6.0부터 마시멜로부터 일부권한에 대해 사용자에게 동의 필요!", Toast.LENGTH_LONG).show();

                uploadbtn.setEnabled(false);
                downloadbtn.setEnabled(false);
                metainfobtn.setEnabled(false);
                deletebtn.setEnabled(false);  // 버튼 비활성화
            }
        }


    }


    @Override
    public void onClick(View view) {
        Intent i = null;

        switch (view.getId()) {
            case R.id.uploadbtn:
                i = new Intent(this, UploadActivity.class);
                break;
            case R.id.downloadbtn:
                i = new Intent(this, DowloadActivity.class);
                break;

            case R.id.metainfobtn:
                i = new Intent(this, MetaInfoActivity.class);
                break;
            case R.id.deletebtn:
                deleteFile();
                break;

            default:
                break;
        }

        if (i != null) {
            startActivity(i);
        }

    }

    private void deleteFile() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();

        StorageReference desertRef = storageReference.child("storage/20181013_115822.jpg");
        desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    uploadbtn.setEnabled(true);
                    downloadbtn.setEnabled(true);
                    metainfobtn.setEnabled(true);
                    deletebtn.setEnabled(true);


                }
                break;
            default:
                break;
        }
    }
}
