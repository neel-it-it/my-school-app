package com.example.schoolmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.google.android.material.tabs.TabLayout;

public class login extends AppCompatActivity {

    EditText email;
    EditText pass;
    TextView fp;
    Button button;
    EditText user;
    EditText uid;
    AwesomeValidation awesomeValidation;

    TabLayout tabLayout;
    ViewPager viewPager;

    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        user = findViewById(R.id.user);
        uid = findViewById(R.id.uid);
        fp = findViewById(R.id.fp);
        button = findViewById(R.id.button);
        viewPager = findViewById(R.id.view_pager);

        tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("student"));
        tabLayout.addTab(tabLayout.newTab().setText("Parents"));
        tabLayout.addTab(tabLayout.newTab().setText("Teacher"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final loginAdapter adapter = new loginAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.setTranslationY(300);
        tabLayout.setAlpha(v);


        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }




}

