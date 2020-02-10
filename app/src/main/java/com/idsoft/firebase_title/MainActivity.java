package com.idsoft.firebase_title;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;
import com.idsoft.firebase_title.analytics.AanlyticsActivity;
import com.idsoft.firebase_title.auth.aauthactivity;
import com.idsoft.firebase_title.cloudmessaging.cloud_messaging;
import com.idsoft.firebase_title.cloudstorage.ColudStorageActivity;
import com.idsoft.firebase_title.crashlytics.CrashlyticsActivity;
import com.idsoft.firebase_title.dynamiclink.dynamiclink;
import com.idsoft.firebase_title.firesotre.firesotre;
import com.idsoft.firebase_title.hosting.hosting;
import com.idsoft.firebase_title.realtimedb.MemoActivity;
import com.idsoft.firebase_title.remoteconfig.remoteconfig;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fire = (Button) findViewById(R.id.firebtn);
        Button realtime = (Button) findViewById(R.id.realtimebtn);
        Button firebasecloudfiresotrebtn = (Button) findViewById(R.id.firbasecloudfirstorebtn);
        Button storage = (Button) findViewById(R.id.storagebtn);
        Button hosting = (Button) findViewById(R.id.hostingbtn);
        Button crash = (Button) findViewById(R.id.crachbtn);
        Button cloudbtn = (Button) findViewById(R.id.cloudbtn);
        Button remote = (Button) findViewById(R.id.remotebtn);
        Button dynamic = (Button) findViewById(R.id.dynamicbtn);
        Button anal = (Button) findViewById(R.id.analbtn);

        fire.setOnClickListener((View.OnClickListener) this);
        realtime.setOnClickListener((View.OnClickListener) this);
        firebasecloudfiresotrebtn.setOnClickListener((View.OnClickListener) this);
        storage.setOnClickListener((View.OnClickListener) this);
        hosting.setOnClickListener((View.OnClickListener) this);
        crash.setOnClickListener((View.OnClickListener) this);
        cloudbtn.setOnClickListener((View.OnClickListener) this);
        remote.setOnClickListener((View.OnClickListener) this);
        dynamic.setOnClickListener((View.OnClickListener) this);
        anal.setOnClickListener((View.OnClickListener) this);

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
//
    }


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

            case R.id.storagebtn:
                i = new Intent(MainActivity.this, ColudStorageActivity.class);
                startActivity(i);
                break;

            case R.id.hostingbtn:
                i = new Intent(MainActivity.this, hosting.class);
                startActivity(i);
                break;

                case R.id.crachbtn:
                i = new Intent(MainActivity.this, CrashlyticsActivity.class);
                startActivity(i);
                break;

            case R.id.cloudbtn:
                i = new Intent(MainActivity.this, cloud_messaging.class);
                startActivity(i);
                break;

            case R.id.remotebtn:
                i = new Intent(MainActivity.this, remoteconfig.class);
                startActivity(i);
                break;

            case R.id.dynamicbtn:
                i = new Intent(MainActivity.this, dynamiclink.class);
                startActivity(i);
                break;

            case R.id.analbtn:
                i = new Intent(MainActivity.this, AanlyticsActivity.class);
                startActivity(i);
                break;


            default:
                break;

        }
    }
}
