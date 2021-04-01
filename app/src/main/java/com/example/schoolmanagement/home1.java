package com.example.schoolmanagement;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolmanagement.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;


public class home1 extends Fragment {
    private HomeViewModel homeViewModel;
    private RecyclerView rv_dash;
    private List<String> title;
    private List<Integer>mimage;
    private MyAdapter adapter;


    public home1() {
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
        View view = inflater.inflate(R.layout.fragment_home1, container, false);
        rv_dash = view.findViewById(R.id.rv_dash);


        title = new ArrayList<>();
        mimage =new ArrayList<>();

        adapter = new MyAdapter(getActivity(), title , mimage );

        mimage.add(R.drawable.ic_hwork_try);
        mimage.add(R.drawable.ic_person_try);
        mimage.add(R.drawable.ic_res_try);
        mimage.add(R.drawable.ic_recei_try);
        mimage.add(R.drawable.ic_table_try);
        mimage.add(R.drawable.ic_note_try);
        mimage.add(R.drawable.ic_commu_try);
        mimage.add(R.drawable.ic_sylla_try);
        mimage.add(R.drawable.ic_bus_try);
        mimage.add(R.drawable.ic_atten_try);

        title.add("Home work");
        title.add("Student info");
        title.add("result");
        title.add("receipt");
        title.add("Timetable");
        title.add("event");
        title.add("communication");
        title.add("Syllabus coverage");
        title.add("Bus route");
        title.add("Attendance");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity() , 3 , GridLayoutManager.VERTICAL , false );
        rv_dash.setLayoutManager(gridLayoutManager);
        rv_dash.setHasFixedSize(true);
        rv_dash.setAdapter(adapter);


        return view;

    }
}