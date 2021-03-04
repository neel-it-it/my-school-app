package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Add_EventFragment extends Fragment {


    private RecyclerView rv_addevent;
    private ArrayList<addeventmodel> list;
    private addeventadapter madapter;

    public Add_EventFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add__event, container, false);
        rv_addevent = view.findViewById(R.id.rv_addevent);

        setdata();
        setadapter();

        return  view;
    }

    private void setadapter() {
        madapter = new addeventadapter(Add_EventFragment.this,list);
        rv_addevent.setAdapter(madapter);
        rv_addevent.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {
        list = new ArrayList<>();
        addeventmodel model1 = new addeventmodel();
        model1.setImage(R.id.profile_image);
        model1.setTitle("Diwali Card");
        model1.setDate("15 november");
        list.add(model1);

        addeventmodel model2 = new addeventmodel();
        model2.setImage(R.id.profile_image);
        model2.setTitle("Rangoli competition");
        model2.setDate("17 november");
        list.add(model2);

        addeventmodel model3 = new addeventmodel();
        model3.setImage(R.id.profile_image);
        model3.setTitle("Christmas");
        model3.setDate("25 December");
        list.add(model3);

        addeventmodel model4 = new addeventmodel();
        model4.setImage(R.id.profile_image);
        model4.setTitle("Holi Celebration");
        model4.setDate("21 March");
        list.add(model4);
    }
}