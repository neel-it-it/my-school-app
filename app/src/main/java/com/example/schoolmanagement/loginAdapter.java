package com.example.schoolmanagement;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class loginAdapter extends FragmentPagerAdapter {

    private final Context context;
    private final int totalTabs;

    public loginAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context=context;
        this.totalTabs=totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new studentfragment();
            case 1:
                return new parentfragment();
            case 2:
                return new teacherfragment();
            default:
                return null;
    }


}

    @Override
    public int getCount() {
        return totalTabs;
    }
}
