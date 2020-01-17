package com.idsoft.firebase_title.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.idsoft.firebase_title .R;

import java.util.ArrayList;
import java.util.List;

public class firebaseuiactivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebaseuiactivity);

        Button firebaseuiaubtn = findViewById(R.id.firebaseauthbtn);





//        firebaseuiaubtn.setOnClickListener((View.OnClickListener) this);

        firebaseuiaubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){
                    case R.id.firebaseauthbtn:
                        signin();
                        break;
                        default:
                            break;
                }

            }

            private void signin() {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder()
                        .setTheme(getSelectedTheme())
                        .setLogo(getSelectedLogo())
                        .setAvailableProviders(getSelectedProvider())
                        .setTosAndPrivacyPolicyUrls("https://naver.com","https://google.com")
                        .setIsSmartLockEnabled(true)
                        .build(),RC_SIGN_IN);

            }

            private int getSelectedTheme(){
                return AuthUI.getDefaultTheme();
            }

            private int getSelectedLogo(){
                return AuthUI.NO_LOGO;
            }

            private List<AuthUI.IdpConfig> getSelectedProvider(){
                List<AuthUI.IdpConfig> selectedProviders = new ArrayList<>();
                CheckBox googlechk = (CheckBox)findViewById(R.id.google);
                CheckBox facebook = (CheckBox)findViewById(R.id.facebook);
                CheckBox twitter = (CheckBox)findViewById(R.id.twiter);
                CheckBox email = (CheckBox)findViewById(R.id.email);

                if (googlechk.isChecked()){

                    selectedProviders.add(new AuthUI.IdpConfig.GoogleBuilder().build());

                }

                if (facebook.isChecked()){
                    selectedProviders.add(new AuthUI.IdpConfig.FacebookBuilder().build());

                }
                if (twitter.isChecked()){
                    selectedProviders.add(new AuthUI.IdpConfig.TwitterBuilder().build());

                }
                if (email.isChecked()){
                    selectedProviders.add(new AuthUI.IdpConfig.EmailBuilder().build());

                }

                return selectedProviders;
            }
        });




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            }
            else {

            }
        }
    }





    private int getSelectedTheme(){
        return AuthUI.getDefaultTheme();

//        return R.style.DarkTheme;
//        return R.style.GreenTheme;


    }

    private int getSelectedLogo(){
        return AuthUI.NO_LOGO;
    }

}

