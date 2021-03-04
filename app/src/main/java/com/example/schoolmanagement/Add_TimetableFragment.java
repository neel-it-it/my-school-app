package com.example.schoolmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Add_TimetableFragment extends Fragment {


    private RecyclerView rv_timet;
    private ArrayList<addtimetmodel> list;
    private addtimetadapter madapter;
    private FloatingActionButton fb2;

    public Add_TimetableFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add__timetable, container, false);
        rv_timet = view.findViewById(R.id.rv_timet);
        fb2 = view.findViewById(R.id.fb2);
        fb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),S_Timetable.class);
                startActivity(intent);
            }
        });

        setdata();
        setadapter();
        return view;
    }

    private void setadapter() {
        madapter = new addtimetadapter(Add_TimetableFragment.this,list);
        rv_timet.setAdapter(madapter);
        rv_timet.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {
        list = new ArrayList<>();
        addtimetmodel model1 = new addtimetmodel();
        model1.setStandard("Class  5");
        model1.setDiv("division  B");
        model1.setFile_download("File download");
        model1.setId("T0001");
        list.add(model1);

        addtimetmodel model2 = new addtimetmodel();
        model2.setStandard("Class  6");
        model2.setDiv("division  B");
        model2.setFile_download("File download");
        model2.setId("T0002");
        list.add(model2);

        addtimetmodel model3 = new addtimetmodel();
        model3.setStandard("Class  7");
        model3.setDiv("division  B");
        model3.setFile_download("File download");
        model3.setId("T0003");
        list.add(model3);

        addtimetmodel model4 = new addtimetmodel();
        model4.setStandard("Class  8");
        model4.setDiv("division  B");
        model4.setFile_download("File download");
        model4.setId("T0004");
        list.add(model4);

        addtimetmodel model5 = new addtimetmodel();
        model5.setStandard("Class  9");
        model5.setDiv("division  B");
        model5.setFile_download("File download");
        model5.setId("T0005");
        list.add(model5);
    }
}