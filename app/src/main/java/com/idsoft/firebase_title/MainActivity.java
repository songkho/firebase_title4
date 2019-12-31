package com.idsoft.firebase_title;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idsoft.firebase_title.auth.aauthactivity;

import com.idsoft.firebase_title.auth.aauthactivity;



public class MainActivity extends AppCompatActivity  {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


        Button fire = (Button) findViewById(R.id.firebtn);
//        fire.setOnClickListener((View.OnClickListener) this);

        fire.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                      switch (view.getId())
                      {
                          case R.id.firebtn:
                              Intent i = new Intent(MainActivity.this, aauthactivity.class);
                              startActivity(i);
                              break;

                              default:
                                  break;
                      }

                    }
                });

    }
}
