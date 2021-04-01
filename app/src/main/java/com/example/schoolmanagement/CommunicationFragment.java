package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class CommunicationFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_communication);

        tabLayout = viewPager.findViewById(R.id.tabs);
        viewPager = viewPager.findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Send"));
        tabLayout.addTab(tabLayout.newTab().setText("Receive"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }

    private void getSupportFragmentManager() {
    }

    private void setContentView(int fragment_communication) {

    }


}