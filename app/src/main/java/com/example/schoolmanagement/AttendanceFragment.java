package com.example.schoolmanagement;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intrusoft.scatter.ChartData;
import com.intrusoft.scatter.PieChart;

import java.util.ArrayList;
import java.util.List;

public class AttendanceFragment extends Fragment {

    PieChart pieChart;
    List<ChartData> data, data1;
    public AttendanceFragment() {
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
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
        pieChart = view.findViewById(R.id.pie_chart);
        data = new ArrayList<>();
        data.add(new ChartData("35%", 35));
        data.add(new ChartData("55%", 55));
        data.add(new ChartData("10%", 10));

        data1 = new ArrayList<>();
        data1.add(new ChartData("35%", 35, Color.BLACK, Color.parseColor("#f1f1f1")));
        data1.add(new ChartData("55%", 30, Color.BLACK, Color.parseColor("#f2f2f2")));
        data1.add(new ChartData("10%", 10, Color.BLACK, Color.parseColor("#f3f3f3")));

        pieChart.setChartData(data);
        return view;
    }
}