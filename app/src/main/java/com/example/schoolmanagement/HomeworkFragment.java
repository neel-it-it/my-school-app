package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeworkFragment extends Fragment {


    private RecyclerView rv_homework;
    private ArrayList<homworkmodel> list;
    private homworkadpater madapter;

    public HomeworkFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homework, container, false);
        rv_homework =view.findViewById(R.id.rv_homework);
        setdata();
        setadapter();
        return  view;
    }

    private void setadapter() {
        madapter = new homworkadpater(HomeworkFragment.this,list);
        rv_homework.setAdapter(madapter);
        rv_homework.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void setdata() {
        list = new ArrayList<>();
        homworkmodel model = new homworkmodel();
        model.setImage(R.drawable.sube1);
        model.setSubname("English");
        model.setSubject("English");
        model.setStandname("A");
        model.setStand("Class");
        list.add(model);

        homworkmodel model1 = new homworkmodel();
        model1.setImage(R.drawable.subj1);
        model1.setSubname("Java");
        model1.setSubject("Java");
        model1.setStandname("B");
        model1.setStand("Class");
        list.add(model1);

        homworkmodel model2 = new homworkmodel();
        model2.setImage(R.drawable.subm1);
        model2.setSubname("Maths");
        model2.setSubject("Maths");
        model2.setStandname("C");
        model2.setStand("Class");
        list.add(model2);

        homworkmodel model3 = new homworkmodel();
        model3.setImage(R.drawable.subcs1);
        model3.setSubname("CNS");
        model3.setSubject("CNS");
        model3.setStandname("D");
        model3.setStand("Class");
        list.add(model3);

        homworkmodel model4 = new homworkmodel();
        model4.setImage(R.drawable.subc1);
        model4.setSubname("CN");
        model4.setSubject("CN");
        model4.setStandname("E");
        model4.setStand("Class");
        list.add(model4);


    }
}