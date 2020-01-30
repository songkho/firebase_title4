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

public class aauthactivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aauthactivity);



        Button firebaseuibtn = (Button)findViewById(R.id.firebaseauthbtn);
        firebaseuibtn.setOnClickListener(this);

        Button firebasesignout = (Button)findViewById(R.id.firebaesignout);
        firebasesignout.setOnClickListener(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
            // 인증이 되어 있는 상태
            firebaseuibtn.setEnabled(false);
            firebasesignout.setEnabled(true);
        }
        else
        {
            // 인증이 되어 있지 않은 상태
            firebaseuibtn.setEnabled(true);
            firebasesignout.setEnabled(false);
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.firebaseauthbtn:
                Intent i = new Intent(this, firebaseuiactivity.class);
                startActivity(i);
                break;
            case R.id.firebaesignout:
                signOut();
                break;
            default:
                break;
        }
    }

    private void signOut()
    {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            finish();
                        }
                        else
                        {
                        }
                    }
                });
    }
}
