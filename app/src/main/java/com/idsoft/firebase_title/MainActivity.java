package com.idsoft.firebase_title;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.idsoft.firebase_title.auth.aauthactivity;
import com.idsoft.firebase_title.cloudstorage.ColudStorageActivity;
import com.idsoft.firebase_title.crashlytics.CrashlyticsActivity;
import com.idsoft.firebase_title.firesotre.firesotre;
import com.idsoft.firebase_title.hosting.hosting;
import com.idsoft.firebase_title.realtimedb.MemoActivity;


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

        fire.setOnClickListener((View.OnClickListener) this);
        realtime.setOnClickListener((View.OnClickListener) this);
        firebasecloudfiresotrebtn.setOnClickListener((View.OnClickListener) this);
        storage.setOnClickListener((View.OnClickListener) this);
        hosting.setOnClickListener((View.OnClickListener) this);
        crash.setOnClickListener((View.OnClickListener) this);

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

            default:
                break;

        }
    }
}
