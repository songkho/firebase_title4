package com.idsoft.firebase_title.cloudstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.idsoft.firebase_title.R;

import java.io.File;

public class UploadActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQ_CODE_SELECT_IMAGE = 1000;

    private String mImgPath = null;
    private String mImgTitle = null;
    private String mImgOrient = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        Button uploadbtn = findViewById(R.id.imguploadbtn);

        uploadbtn.setOnClickListener(this);

        getGallery();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                getImageNameToUri(uri);

                try {
                    Bitmap bm = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    ImageView img = findViewById(R.id.showimg);
                    img.setImageBitmap(bm);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imguploadbtn:
                uploadFile(mImgPath);
                break;
            default:
                break;

        }

    }



    private void getGallery(){
        Intent intent = null;

        if (Build.VERSION.SDK_INT >= 19){
            intent =  new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }else {
            intent = new Intent(Intent.ACTION_GET_CONTENT);

        }

        intent.setType("image/*");
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
    }

    //uri 정보를 이용하여 사진정보를 가져오기 위한것



    private void getImageNameToUri(Uri data){
        String[] proj = {
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.ORIENTATION
        };

        Cursor cursor = this.getContentResolver().query(data,  proj, null, null, null);
        cursor.moveToFirst();// Cursor를 첫번째 행으로 이동

                // Cursor는 데이터 베이스에 저장되어 있는 데이터들을 가져와서 테이블을 이루고 있는 행(Row)을 참조하여 사용을 할 수 있게 해줍니다.
        //DB는 테이블로 구성 행과열로 구성 Cursor는 행을 참조

        int column_data = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        int column_title = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE);
        int column_orientation = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.ORIENTATION);

        mImgPath = cursor.getString(column_data);
        mImgTitle = cursor.getString(column_title);
        mImgOrient = cursor.getString(column_orientation);

        //
        // getColumnIndexOrThrow()
        // 특정 필드의 인덱스값을 반환하며, 필드가 존재하지 않을경우 예외를 발생시킵니다.

        Log.d("namjinha", "mImgPath = " + mImgPath);
        Log.d("namjinha", "mImgTitle = " + mImgTitle);
        Log.d("namjinha", "mImgOrient = " + mImgOrient);

    }

    private void uploadFile(String aFilePath) {

        Uri file =  Uri.fromFile(new File(aFilePath));
            StorageMetadata metadata = new StorageMetadata.Builder().setContentType("image/jpeg").build();


        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storagRef = storage.getReference();
        UploadTask uploadTask = storagRef.child("storage/" + file.getLastPathSegment()).putFile(file, metadata);

        uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                Toast.makeText(UploadActivity.this, "Upload is " + progress + "% done", Toast.LENGTH_SHORT).show();
            }
        }).addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onPaused(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                Log.d("namjinha", "Upload is paused");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("namjinha", "Upload Exception");

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(UploadActivity.this, "업로드가 완료되었습니다.!", Toast.LENGTH_SHORT).show();
            }
        });

    }




}
