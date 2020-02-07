package com.idsoft.firebase_title.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.idsoft.firebase_title.R;

public class cloud_messaging extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_messaging);

        Button tokenbtn = findViewById(R.id.tokenbtn);

        tokenbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tokenbtn:

                FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.d("namjinha", "getInstanceId failed", task.getException());

                            return;
                        }

                        String token = task.getResult().getToken();

                        String msg = "InstanceID Token: " + token;
                        Log.d("namjinha", msg);
                        Toast.makeText(cloud_messaging.this, msg, Toast.LENGTH_SHORT).show();

                    }
                });
                break;
            default:
                break;
        }
    }
}
