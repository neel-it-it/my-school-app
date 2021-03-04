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


public class Add_ResultFragment extends Fragment {


    private RecyclerView rv_res;
    private ArrayList<addresultmodel> list;
    private addresadapter madapter;
    private FloatingActionButton fb1;

    public Add_ResultFragment() {
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
        View  view = inflater.inflate(R.layout.fragment_add__result, container, false);
        rv_res = view.findViewById(R.id.rv_res);
        fb1 = view.findViewById(R.id.fb1);
        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),S_Result.class);
                startActivity(intent);
            }
        });

        setdata();
        setadapter();
        return view;
    }

    private void setadapter() {
        madapter = new addresadapter(Add_ResultFragment.this,list);
        rv_res.setAdapter(madapter);
        rv_res.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {
        list = new ArrayList<>();
        addresultmodel model1 = new addresultmodel();
        model1.setStandard("Class  6");
        model1.setDiv("division  B");
        model1.setFile_download("File download");
        model1.setId("R0001");
        list.add(model1);

        addresultmodel model2 = new addresultmodel();
        model2.setStandard("Class  7");
        model2.setDiv("division  B");
        model2.setFile_download("File download");
        model2.setId("R0002");
        list.add(model2);

        addresultmodel model3 = new addresultmodel();
        model3.setStandard("Class  8");
        model3.setDiv("division  B");
        model3.setFile_download("File download");
        model3.setId("R0003");
        list.add(model3);

        addresultmodel model4 = new addresultmodel();
        model4.setStandard("Class  9");
        model4.setDiv("division  B");
        model4.setFile_download("File download");
        model4.setId("R0004");
        list.add(model4);

        addresultmodel model5 = new addresultmodel();
        model5.setStandard("Class  10");
        model5.setDiv("division  B");
        model5.setFile_download("File download");
        model5.setId("R0005");
        list.add(model5);

    }
}