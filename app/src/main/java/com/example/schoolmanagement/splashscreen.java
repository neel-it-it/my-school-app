package com.example.schoolmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;

public class splashscreen extends AppCompatActivity {

    boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loggedIn = PrefUtil.getbooleanPref(Common.isLoggedIn, splashscreen.this);
                if(loggedIn) {
                    startActivity(new Intent(splashscreen.this, MainActivity.class));
                } else {
                    Intent intent=new Intent(splashscreen.this, Login2.class);
                    startActivity(intent);
                }

                finish();
            }
        },3000);
    }
}