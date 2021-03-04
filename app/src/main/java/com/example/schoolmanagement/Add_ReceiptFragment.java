package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Add_ReceiptFragment extends Fragment {


    private RecyclerView rv_addresc;
    private ArrayList<addrescmodel> list;
    private addrescadapter madapter;

    public Add_ReceiptFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add__receipt, container, false);
        rv_addresc = view.findViewById(R.id.rv_addresc);

        setdata();
        setadapter();

        return  view;
    }

    private void setadapter() {
        madapter = new addrescadapter(Add_ReceiptFragment.this,list);
        rv_addresc.setAdapter(madapter);
        rv_addresc.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setdata() {
        list = new ArrayList<>();
        addrescmodel model1 = new addrescmodel();
        model1.setStand("Class  5");
        model1.setDiv("division  B");
        model1.setName("Name : Karan Khatri");
        model1.setFile_download("File download");
        model1.setId("RE0001");
        list.add(model1);

        addrescmodel model2 = new addrescmodel();
        model2.setStand("Class  6");
        model2.setDiv("division  B");
        model2.setName("Name : Akshay sharma");
        model2.setFile_download("File download");
        model2.setId("RE0002");
        list.add(model2);

        addrescmodel model3 = new addrescmodel();
        model3.setStand("Class  7");
        model3.setDiv("division  B");
        model3.setName("Name : Roshan sharma");
        model3.setFile_download("File download");
        model3.setId("RE0003");
        list.add(model3);

        addrescmodel model5 = new addrescmodel();
        model5.setStand("Class  8");
        model5.setDiv("division  B");
        model5.setName("Name : Karan patel");
        model5.setFile_download("File download");
        model5.setId("RE0004");
        list.add(model5);
    }
}