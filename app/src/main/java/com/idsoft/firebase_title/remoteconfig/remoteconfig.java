package com.idsoft.firebase_title.remoteconfig;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.idsoft.firebase_title.BuildConfig;
import com.idsoft.firebase_title.R;

public class remoteconfig extends AppCompatActivity implements View.OnClickListener {

    private static final String WELCOME_MESSAGE_KEY = "welcome_message";
    // 원격 구성키 환영의 메세지를 변경

    private static final String WELCOME_MESSAGE_CAPS_KEY = "welcome_message_caps";
    //환영의 메세지를 대문자로 표시

    private FirebaseRemoteConfig mfirebaseRemoteConfig;
    private TextView mWelComeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remoteconfig);

        mWelComeTextView = findViewById(R.id.welcomtextview);

        Button fetchbton = findViewById(R.id.fetchbutton);

        fetchbton.setOnClickListener(this);

        mfirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(BuildConfig.DEBUG).build();

        mfirebaseRemoteConfig.setConfigSettings(configSettings);
        mfirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);

        fetchWelcome();


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fetchbutton:
                fetchWelcome();
                break;
            default:
                break;
        }

    }

    private void fetchWelcome() {

        long cacheExpriation = 3600; // 1시간

        if (mfirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()){
            cacheExpriation = 0;
        }
        mfirebaseRemoteConfig.fetch(cacheExpriation).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(remoteconfig.this, "Fetch Succeded", Toast.LENGTH_SHORT).show();
                    mfirebaseRemoteConfig.activateFetched();
                }else {
                    Toast.makeText(remoteconfig.this, "Fetch Failed", Toast.LENGTH_SHORT).show();

                }
                diplayWelcomeMessage();
            }

            private void diplayWelcomeMessage() {

                String  welcomeMessage = mfirebaseRemoteConfig.getString(WELCOME_MESSAGE_KEY);

                if (mfirebaseRemoteConfig.getBoolean(WELCOME_MESSAGE_CAPS_KEY)){
                    mWelComeTextView.setAllCaps(true);
                }
                else {
                    mWelComeTextView.setAllCaps(false);
                }
                mWelComeTextView.setText(welcomeMessage);

            }
        });
    }

}
