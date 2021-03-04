package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TeacherinfoFragment extends Fragment {


    private RecyclerView Rv_teach;
    private ArrayList<teachermodel> list;
    private Teacheradapter madapter;


    public TeacherinfoFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teacherinfo, container, false);
        Rv_teach = view.findViewById(R.id.Rv_teach);
        setdata();
        setadapter();
        return  view;
    }

    private void setadapter() {
        madapter = new Teacheradapter(TeacherinfoFragment.this,list);
        Rv_teach.setAdapter(madapter);
        Rv_teach.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {

        list = new ArrayList<>();


        teachermodel tmodel = new teachermodel();
        tmodel.setImage(R.drawable.tacher);
        tmodel.setTitle("Bharat Sharma");
        tmodel.setDate("15 November");
        list.add(tmodel);

        teachermodel tmodel2 = new teachermodel();
        tmodel2.setImage(R.drawable.te2);
        tmodel2.setTitle("Himansu Tyagi");
        tmodel2.setDate("17 November");
        list.add(tmodel2);

        teachermodel tmodel3 = new teachermodel();
        tmodel3.setImage(R.drawable.te3);
        tmodel3.setTitle("Ronit Patel");
        tmodel3.setDate("25 December");
        list.add(tmodel3);

        teachermodel tmodel4 = new teachermodel();
        tmodel4.setImage(R.drawable.te4);
        tmodel4.setTitle("Miten Patel");
        tmodel4.setDate("21 March");
        list.add(tmodel4);

    }
}