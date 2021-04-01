package com.example.schoolmanagement;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.schoolmanagement.ui.main.SectionsPagerAdapter;

public class Login2 extends AppCompatActivity {
    EditText email;
    EditText pass;
    TextView fp;
    Button button;
    EditText user;
    EditText uid;

    TabLayout tabLayout;
    ViewPager viewPager;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        pass=findViewById(R.id.pass);
        uid=findViewById(R.id.uid);
        fp=findViewById(R.id.fp);


        button=findViewById(R.id.button);



        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Student"));
        tabLayout.addTab(tabLayout.newTab().setText("Parents"));
        tabLayout.addTab(tabLayout.newTab().setText("Teacher"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final loginAdapter adapter=new loginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTranslationY(300);
        tabLayout.setAlpha(v);
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }
}