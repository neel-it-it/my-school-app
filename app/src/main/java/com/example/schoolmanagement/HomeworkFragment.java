package com.example.schoolmanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.stu_homework.StuHomeworkResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeworkFragment extends Fragment {


    private RecyclerView rv_homework;
    private homworkadpater madapter;
    private CardView download;

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
        download = view.findViewById(R.id.download);

    /*    download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriWebsite = Uri.parse("D:\\xampp\\htdocs\\newone\\SchoolManegment\\pdf\\ajava.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW,uriWebsite);
                startActivity(intent);
            }
        });*/
        rv_homework =view.findViewById(R.id.rv_homework);

        getHomeworkData(PrefUtil.getstringPref(Common.userId, getActivity()));
        return  view;
    }

    private void setadapter() {

    }

    private void getHomeworkData(String student_id){
        Common.apiInterface.stuhomework(student_id).enqueue(new Callback<StuHomeworkResponse>() {
            @Override
            public void onResponse(Call<StuHomeworkResponse> call, Response<StuHomeworkResponse> response) {
                StuHomeworkResponse stuHomeworkResponse = response.body();

                if(stuHomeworkResponse.getSuccess() == 1) {
                    madapter = new homworkadpater(stuHomeworkResponse.getData(), getActivity());
                    rv_homework.setAdapter(madapter);
                    rv_homework.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }

            @Override
            public void onFailure(Call<StuHomeworkResponse> call, Throwable t) {

            }
        });

    }
}