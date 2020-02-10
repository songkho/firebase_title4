package com.idsoft.firebase_title.analytics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.idsoft.firebase_title.R;

public class AanlyticsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aanlytics);

        Button onebtn = findViewById(R.id.onebtn);
        Button twobtn = findViewById(R.id.twobtn);
        Button threebtn = findViewById(R.id.threebtn);

        onebtn.setOnClickListener(this);
        twobtn.setOnClickListener(this);
        threebtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = null;

        switch (view.getId()) {
            case R.id.onebtn:
                i = new Intent(this, onetActivity.class);
                startActivity(i);
                break;
            case R.id.twobtn:
                i = new Intent(this, twoActivity.class);
                startActivity(i);
                break;
            case R.id.threebtn:
                i = new Intent(this, threeActivity.class);
                startActivity(i);
                break;
        }


    }
}
