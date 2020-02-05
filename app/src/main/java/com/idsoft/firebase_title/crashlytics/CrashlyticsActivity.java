package com.idsoft.firebase_title.crashlytics;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.idsoft.firebase_title.R;

import io.fabric.sdk.android.Fabric;

public class CrashlyticsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crashlytics);

        Crashlytics.log("crashactivity oncreate() 1");
        Crashlytics.log(Log.INFO, Crashlytics.TAG, "Crashlyticsactivity oncreate() 2");

        //파이어베이스 크래쉬틱스 추적키 추가

        Crashlytics.setString("CrashlyticsActivity", "onCreate()");
        Crashlytics.setInt("Int", 100);

        Fabric.with(this, new Crashlytics());

        Button crash = findViewById(R.id.crashbtn2);
        crash.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
          switch (view.getId()){
                      case R.id.crashbtn2:
                          Crashlytics.getInstance().crash();
                          break;
                  }

    }
}
