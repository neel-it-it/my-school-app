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
        tmodel.setDate("Joining Date:");
        tmodel.setPassword("Password:");
        tmodel.setEmail("E-mail:");
        tmodel.setAddress("Address:");
        tmodel.setMobile("Mobile no:");
        tmodel.setExper("Experience:");
        tmodel.setClassteacher("Class-Teacher:");
        tmodel.setJoinans("16-2-1990");
        tmodel.setPassans("***********");
        tmodel.setMailans("pacx@gmail.com");
        tmodel.setAddans("A-1/102, Surya appt");
        tmodel.setMobans("9874558747");
        tmodel.setExans("4 years");
        tmodel.setClassans("Standard 1");
        list.add(tmodel);

        teachermodel tmodel2 = new teachermodel();
        tmodel2.setImage(R.drawable.te2);
        tmodel2.setTitle("Himansu Tyagi");
        tmodel2.setDate("Joining Date:");
        tmodel2.setPassword("Password:");
        tmodel2.setEmail("E-mail:");
        tmodel2.setAddress("Address");
        tmodel2.setMobile("Mobile no:");
        tmodel2.setExper("Experience:");
        tmodel2.setClassteacher("Class-Teacher:");
        tmodel2.setJoinans("16-2-1990");
        tmodel2.setPassans("***********");
        tmodel2.setMailans("abcd@gmail.com");
        tmodel2.setAddans("A-1/102, casa appt");
        tmodel2.setMobans("9784785447");
        tmodel2.setExans("5 years");
        tmodel2.setClassans("Standard 3");
        list.add(tmodel2);

        teachermodel tmodel3 = new teachermodel();
        tmodel3.setImage(R.drawable.te3);
        tmodel3.setTitle("Ronit Patel");
        tmodel3.setDate("Joining Date");
        tmodel3.setPassword("Password:");
        tmodel3.setEmail("E-mail:");
        tmodel3.setAddress("Address");
        tmodel3.setMobile("Mobile no:");
        tmodel3.setExper("Experience:");
        tmodel3.setClassteacher("Class-Teacher:");
        tmodel3.setJoinans("16-2-1990");
        tmodel3.setPassans("***********");
        tmodel3.setMailans("asds@gmail.com");
        tmodel3.setAddans("A-1/102, vandemataram appt");
        tmodel3.setMobans("9457894747");
        tmodel3.setExans("6 years");
        tmodel3.setClassans("Standard 4");
        list.add(tmodel3);

        teachermodel tmodel4 = new teachermodel();
        tmodel4.setImage(R.drawable.te4);
        tmodel4.setTitle("Miten Patel");
        tmodel4.setDate("Joining Date:");
        tmodel4.setPassword("Password:");
        tmodel4.setEmail("E-mail:");
        tmodel4.setAddress("Address:");
        tmodel4.setMobile("Mobile no:");
        tmodel4.setExper("Experience:");
        tmodel4.setClassteacher("Class-Teacher:");
        tmodel4.setJoinans("16-2-1990");
        tmodel4.setPassans("***********");
        tmodel4.setMailans("kghd@gmail.com");
        tmodel4.setAddans("A-1/102, Suryarath appt");
        tmodel4.setMobans("9987458747");
        tmodel4.setExans("6 years");
        tmodel4.setClassans("Standard 6");
        list.add(tmodel4);

    }
}