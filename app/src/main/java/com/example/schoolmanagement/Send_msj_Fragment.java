package com.example.schoolmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Send_msj_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.send_msj,container,false);
        return root;
    }
}
