package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class EventFragment extends Fragment {

    private RecyclerView rv_event;
    private ArrayList<eventmodel> list;
    private eventadapter madapter;

    public EventFragment() {
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
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        rv_event = view.findViewById(R.id.rv_event);
        setdata();
        setadapter();
        return view;
    }

    private void setadapter() {
        madapter = new eventadapter(EventFragment.this,list);
        rv_event.setAdapter(madapter);
        rv_event.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {
        list = new ArrayList<>();


        eventmodel model1 = new eventmodel();
        model1.setImage(R.drawable.diwali);
        model1.setTitle("Diwali Card");
        model1.setDate("15 November");
        list.add(model1);

        eventmodel model2 = new eventmodel();
        model2.setImage(R.drawable.rangoli);
        model2.setTitle("Rangoli Competition");
        model2.setDate("17 November");
        list.add(model2);

        eventmodel model = new eventmodel();
        model.setImage(R.drawable.chris);
        model.setTitle("Christmas");
        model.setDate("25 December");
        list.add(model);

        eventmodel model3 = new eventmodel();
        model3.setImage(R.drawable.holi);
        model3.setTitle("Holi Celebration");
        model3.setDate("21 March");
        list.add(model3);




    }
}