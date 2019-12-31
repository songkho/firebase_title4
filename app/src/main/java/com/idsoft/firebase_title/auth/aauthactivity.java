package com.idsoft.firebase_title.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idsoft.firebase_title.R;

public class aauthactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aauthactivity);

        Button firebaseuibtn = findViewById(R.id.firebaseauthbtn);

        firebaseuibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.firebaseauthbtn:
                        Intent i = new Intent(aauthactivity.this, firebaseuiactivity.class);
                        startActivity(i);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
