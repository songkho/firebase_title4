package com.idsoft.firebase_title.analytics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.idsoft.firebase_title.R;

public class threeActivity extends AppCompatActivity {

    private Fanalytics mFanlytics = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        mFanlytics = new Fanalytics();
        mFanlytics.initFirebaseAnalytics(this);
        mFanlytics.sendLogEvent(Fanalytics.FIREBASE_ITEMID_THREEACTIVITY,  Fanalytics.FIREBASE_ITEMANME_THREEACTIVITY);

    }
}
