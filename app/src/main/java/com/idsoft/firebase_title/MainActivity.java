package com.idsoft.firebase_title;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idsoft.firebase_title.auth.aauthactivity;

import com.idsoft.firebase_title.auth.aauthactivity;
import com.idsoft.firebase_title.firesotre.firesotre;
import com.idsoft.firebase_title.realtimedb.MemoActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button fire = (Button) findViewById(R.id.firebtn);
        Button realtime = (Button) findViewById(R.id.realtimebtn);
        Button firebasecloudfiresotrebtn = (Button) findViewById(R.id.firbasecloudfirstorebtn);

        fire.setOnClickListener((View.OnClickListener) this);
        realtime.setOnClickListener((View.OnClickListener) this);
        firebasecloudfiresotrebtn.setOnClickListener((View.OnClickListener) this);

//
//        fire.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                switch (view.getId()) {
//                    case R.id.firebtn:
//                        Intent i = new Intent(MainActivity.this, aauthactivity.class);
//                        startActivity(i);
//                        break;
//
//                    default:
//                        break;
//                }
//
//            }
//        });
//
//        realtime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                switch (view.getId()) {
//                    case R.id.realtimebtn:
//                        Intent i2 = new Intent(MainActivity.this, MemoActivity.class);
//                        startActivity(i2);
//                        break;
//
//                    default:
//                        break;
//                }
//
//            }
//        });
//
//        firebasecloudfiresotrebtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        switch (view.getId()) {
//                    case R.id.firbasecloudfirstorebtn:
//                        Intent i3 = new Intent(MainActivity.this, firesotre.class);
//                        startActivity(i3);
//                        break;
//
//                    default:
//                        break;
//                }
//
//                    }
//                });
//
    }
//
    @Override
    public void onClick(View view) {

        Intent i = null;

        switch (view.getId()) {
            case R.id.realtimebtn:
                i = new Intent(MainActivity.this, MemoActivity.class);
                startActivity(i);
                break;


            case R.id.firebtn:
                i = new Intent(MainActivity.this, aauthactivity.class);
                startActivity(i);
                break;

            case R.id.firbasecloudfirstorebtn:
                i = new Intent(MainActivity.this, firesotre.class);
                startActivity(i);
                break;

            default:
                break;

        }
    }
}
