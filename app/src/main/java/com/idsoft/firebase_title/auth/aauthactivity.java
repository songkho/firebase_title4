package com.idsoft.firebase_title.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.idsoft.firebase_title.R;

public class aauthactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aauthactivity);

        Button firebaseuibtn = findViewById(R.id.firebaseauthbtn);
        Button firebasesignout = findViewById(R.id.firebaesignout);

        firebaseuibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.firebaseauthbtn:
                        Intent i = new Intent(aauthactivity.this, firebaseuiactivity.class);
                        startActivity(i);
                        break;

                    case R.id.firebaesignout:
                        signOut();
                        break;

                    default:
                        break;


                }
            }
        });

        firebasesignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            firebaseuibtn.setEnabled(false);
            firebasesignout.setEnabled(true);
        } else {
            firebaseuibtn.setEnabled(true);
            firebasesignout.setEnabled(false);

        }
    }

    private void signOut() {

        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    finish();
                }
            }
        });

    }
}
