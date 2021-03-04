package com.example.schoolmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Add_HomeworkFragment extends Fragment {


    private RecyclerView rv_homew;
    private ArrayList<addhomemodel>list;
    private addhomeadapter madapter;
    private FloatingActionButton fb;

    public Add_HomeworkFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add__homework, container, false);
        rv_homew = view.findViewById(R.id.rv_homew);
        fb=view.findViewById(R.id.fb);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),S_Homework.class);
                startActivity(intent);
            }
        });
        setdata();
        setadapter();
        return view;
    }

    private void setadapter() {
        madapter = new addhomeadapter(Add_HomeworkFragment.this,list);
        rv_homew.setAdapter(madapter);
        rv_homew.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {

        list = new ArrayList<>();


        addhomemodel model1 = new addhomemodel();
        model1.setStandard("Class  6");
        model1.setDiv("Division  B");
        model1.setSubject("Subject: Maths");
        model1.setFile_download("File download");
        model1.setId("B001");
        list.add(model1);

        addhomemodel model2 = new addhomemodel();
        model2.setStandard("Class  7");
        model2.setDiv("Division  B");
        model2.setSubject("Subject: English");
        model2.setFile_download("File download");
        model2.setId("B002");
        list.add(model2);

        addhomemodel model3 = new addhomemodel();
        model3.setStandard("Class  8");
        model3.setDiv("Division  B");
        model3.setSubject("Subject: Cn");
        model3.setFile_download("File download");
        model3.setId("B003");
        list.add(model3);

        addhomemodel model4 = new addhomemodel();
        model4.setStandard("Class  9");
        model4.setDiv("Division  B");
        model4.setSubject("Subject: Cns");
        model4.setFile_download("File download");
        model4.setId("B004");
        list.add(model4);

        addhomemodel model5 = new addhomemodel();
        model5.setStandard("Class  10");
        model5.setDiv("Division  B");
        model5.setSubject("Subject: DWPD");
        model5.setFile_download("File download");
        model5.setId("B005");
        list.add(model5);

    }
}