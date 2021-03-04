package com.example.schoolmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Add_SyllabuscoverageFragment extends Fragment {


    private RecyclerView rv_addsyl;
    private ArrayList<addsymodel> list;
    private addsyadapter madapter;
    private FloatingActionButton fb3;

    public Add_SyllabuscoverageFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add__syllabuscoverage, container, false);
        rv_addsyl = view.findViewById(R.id.rv_addsyl);
        fb3 = view.findViewById(R.id.fb3);
        fb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),S_Syllabus.class);
                startActivity(intent);
            }
        });

        setdata();
        setadapter();

        return  view;
    }

    private void setadapter() {
        madapter = new addsyadapter(Add_SyllabuscoverageFragment.this,list);
        rv_addsyl.setAdapter(madapter);
        rv_addsyl.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {
        list = new ArrayList<>();
        addsymodel model1 = new addsymodel();
        model1.setStand("Class  5");
        model1.setDiv("division  B");
        model1.setFile_download("File download");
        model1.setId("S0001");
        list.add(model1);

        addsymodel model2 = new addsymodel();
        model2.setStand("Class  6");
        model2.setDiv("division  B");
        model2.setFile_download("File download");
        model2.setId("S0002");
        list.add(model2);

        addsymodel model3 = new addsymodel();
        model3.setStand("Class  7");
        model3.setDiv("division  B");
        model3.setFile_download("File download");
        model3.setId("S0003");
        list.add(model3);

        addsymodel model4 = new addsymodel();
        model4.setStand("Class  8");
        model4.setDiv("division  B");
        model4.setFile_download("File download");
        model4.setId("S0004");
        list.add(model4);

        addsymodel model5 = new addsymodel();
        model5.setStand("Class  9");
        model5.setDiv("division  B");
        model5.setFile_download("File download");
        model5.setId("S0005");
        list.add(model5);
    }
}