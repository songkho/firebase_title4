package com.idsoft.firebase_title.firesotre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.idsoft.firebase_title.R;

import java.util.HashMap;
import java.util.Map;

public class firesotre extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firesotre);

        Button adddatabtn = findViewById(R.id.firesotreadddatabtn);
        Button setdatabtn = findViewById(R.id.firestoresetdatabtn);
        Button deletedocbtn = findViewById(R.id.firestoredeletedocbtn);
        adddatabtn.setOnClickListener(this);
        setdatabtn.setOnClickListener(this);
        deletedocbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.firesotreadddatabtn:
                addData();
                break;

            case R.id.firestoresetdatabtn:
                setData();
                break;

            case R.id.firestoredeletedocbtn:
                deleteDoc();
                break;
                ///
        }

    }




    private void addData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> member = new HashMap<>();
        ////key 값   value값
        //‘사람’을 예로 들면 누구든지 "이름" = "홍길동", "생일" = "몇 월 몇 일" 등으로 구분할 수 있다.
        // 자바의 맵(Map)은 이러한 대응관계를 쉽게 표현할 수 있게 해 주는 자료형이다.


        member.put("name", "홍길동");
        member.put("address", "수원시");
        member.put("age", "25");
        member.put("id", "hong");
        member.put("pwd", "hello!"); // key와 value는 위 예제에서 보듯이 put메소드를 이용하여 입력한다.

        db.collection("users").add(member).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("namjinha", "Document ID = " + documentReference.get());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("namjinha", "Document Error!");

            }
        });


    }

    private void setData() {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Map<String, Object> member = new HashMap<>();
    ////key 값   value값
    //‘사람’을 예로 들면 누구든지 "이름" = "홍길동", "생일" = "몇 월 몇 일" 등으로 구분할 수 있다.
    // 자바의 맵(Map)은 이러한 대응관계를 쉽게 표현할 수 있게 해 주는 자료형이다.

    member.put("name", "홍길동");
    member.put("address", "수원시");
    member.put("age", "25");
    member.put("id", "hong");
    member.put("pwd", "hello!"); // key와 value는 위 예제에서 보듯이 put메소드를 이용하여 입력한다.

    db.collection("users")
            .document("userinfo")
            .set(member).addOnSuccessListener(new OnSuccessListener<Void>() {

        @Override
        public void onSuccess(Void aVoid) {
            Log.d("namjinha", "DocumentSnapshot successfully written!");

        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Log.d("namjinha", "Document Error!");

        }


    });

}

    private void deleteDoc() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").document("userinfo").delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("namjinha", "DocumentSnapshot successfully deleted!");

            }
        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }
}
