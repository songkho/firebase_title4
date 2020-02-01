package com.idsoft.firebase_title.cloudstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.idsoft.firebase_title.R;

public class MetaInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta_info);

        Button metabtn = findViewById(R.id.metabtn);
        metabtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

         switch (view.getId()){
                     case R.id.memobtn:
                         getMetaData();
                         break;
                 }

    }


    private void getMetaData() {

        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference = storage.getReference();
        StorageReference forestRef = storageReference.child("storage/20181013_115822.jpg");

        forestRef.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            @Override
            public void onSuccess(StorageMetadata storageMetadata) {
                String metadata = storageMetadata.getName() + "\n" + storageMetadata.getPath() + "\n" +
                        storageMetadata.getBucket();

                TextView metatxt = findViewById(R.id.metainfotext);
                metatxt.setText(metadata);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });



    }
}
