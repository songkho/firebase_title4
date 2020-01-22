package com.idsoft.firebase_title.firesotre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
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
        Button deletedfieldbtn = findViewById(R.id.firesotredeletefieldbtn);
        Button selectdocbtn = findViewById(R.id.firestoreseldatabtn);
        Button selectwheredocbtn = findViewById(R.id.firestoreselwheredatabtn);

        adddatabtn.setOnClickListener(this);
        setdatabtn.setOnClickListener(this);
        deletedocbtn.setOnClickListener(this);
        deletedfieldbtn.setOnClickListener(this);
        selectdocbtn.setOnClickListener(this);
        selectwheredocbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.firesotreadddatabtn:
                addData();
                break;

            case R.id.firestoresetdatabtn:
                setData();
                break;

            case R.id.firestoredeletedocbtn:
                deleteDoc();
                break;

            case R.id.firesotredeletefieldbtn:
                deleteField();
                break;

            case R.id.firestoreseldatabtn:
                selectDoc();
                break;

            case R.id.firestoreselwheredatabtn:
                selectWhereDoc();
                break;
            ///
        }

    }

    private void selectWhereDoc() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").whereEqualTo("age", 25).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        Log.d("namjinha" , document.getId() + " => " + document.getData());


                        UserInfo userInfo = document.toObject(UserInfo.class);
                        Log.d("namjinha", "name = " + userInfo.getName());
                        Log.d("namjinha", "address = " + userInfo.getAddress());
                        Log.d("namjinha", "id = " + userInfo.getId());
                        Log.d("namjinha", "pwd = " + userInfo.getPwd());
                        Log.d("namjinha", "age = " + userInfo.getAge());

                    }

                }else {
                    Log.d("namjinha" , "Error getting documents: ", task.getException());
                }

            }
        });

    }

    private void selectDoc() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("users").document("userinfo");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("namjinha", "DocumentSnapshot data: " + document.getData());

                        UserInfo userInfo = document.toObject(UserInfo.class);
                        Log.d("namjinha", "name = " + userInfo.getName());
                        Log.d("namjinha", "id = " + userInfo.getId());
                        Log.d("namjinha", "pwd = " + userInfo.getPwd());
                        Log.d("namjinha", "age = " + userInfo.getAge());


                    } else {
                        Log.d("namjinha", "No such document");
                    }
                } else {
                    Log.d("namjinha", "get failed with", task.getException());

                }
            }
        });

    }

    private void deleteField() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("users").document("userinfo");

        Map<String, Object> updates = new HashMap<>();
        updates.put("address", FieldValue.delete());
        updates.put("id", FieldValue.delete());

        docRef.update(updates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("1namjinha", "DocumentSnapshot successfully deleted!");
            }
        });

    }

    private void deleteDoc() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").document("userinfo").delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("namjinha", "DoucumentSnapshot successfully deleted!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("namjinha", "Error deleting document", e);
            }
        });

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
}
