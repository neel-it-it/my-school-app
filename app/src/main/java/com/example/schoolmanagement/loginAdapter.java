package com.example.schoolmanagement;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.schoolmanagement.ui.main.Fragment1;
import com.example.schoolmanagement.ui.main.Fragment2;
import com.example.schoolmanagement.ui.main.Fragment3;

public class loginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public loginAdapter(FragmentManager supportFragmentManager, Context context, int totalTabs) {
        super(supportFragmentManager);
        this.context=context;
        this.totalTabs=totalTabs;
    }

    @NonNull
    @Override
    public int getCount() {
        return totalTabs;
    }
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment1 fragment1=new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2 =new Fragment2();
                return fragment2;
            case 2:
                Fragment3 fragment3=new Fragment3();
                return fragment3;
            default:
                return null;
    }


}};
