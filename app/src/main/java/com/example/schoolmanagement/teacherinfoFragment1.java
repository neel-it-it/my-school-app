package com.example.schoolmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.stu_profile_display.StuProfileDisplayResponse;
import com.example.schoolmanagement.response.teacher_profile_display.TeacherProfileDisplayResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class teacherinfoFragment1 extends Fragment {


    private TextView tv_tname;
    private TextView tv_tdate_ans;
    private TextView tv_tpass_ans;
    private TextView tv_tEmail_ans;
    private TextView tv_tAddress_ans;
    private TextView tv_tMobile_ans;
    private TextView tv_tExperience_ans;
    private TextView tv_tClassteacher_ans;
    private TextView btn_edit;

    public teacherinfoFragment1() {
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
       View view = inflater.inflate(R.layout.fragment_teacherinfo1, container, false);
        tv_tname = view.findViewById(R.id.tv_tname);
        tv_tdate_ans= view.findViewById(R.id.tv_tdate_ans);
        tv_tpass_ans= view.findViewById(R.id.tv_tpass_ans);
        tv_tEmail_ans= view.findViewById(R.id.tv_tEmail_ans);
        tv_tAddress_ans= view.findViewById(R.id.tv_tAddress_ans);
        tv_tMobile_ans= view.findViewById(R.id.tv_tMobile_ans);
        tv_tExperience_ans= view.findViewById(R.id.tv_tExperience_ans);
        tv_tClassteacher_ans = view.findViewById(R.id.tv_tClassteacher_ans);
        btn_edit = view.findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Updateprofile.class);
                startActivity(i);
            }
        });

        Teacherdisplay();
        return  view;

    }

    private void Teacherdisplay() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.teacherprofiledisplay(PrefUtil.getstringPref(Common.userId,getActivity())).enqueue(new Callback<TeacherProfileDisplayResponse>() {
            @Override
            public void onResponse(Call<TeacherProfileDisplayResponse> call, Response<TeacherProfileDisplayResponse> response) {
                if (response.isSuccessful() && response.body()!=null)
                {
                    TeacherProfileDisplayResponse teacherProfileDisplayResponse = response.body();
                    if(teacherProfileDisplayResponse.getSuccess() == 1){
                        tv_tname.setText(teacherProfileDisplayResponse.getStaffName().toString());
                        tv_tpass_ans.setText(teacherProfileDisplayResponse.getStaffPassword().toString());
                        tv_tEmail_ans.setText(teacherProfileDisplayResponse.getStaffEmail().toString());
                        tv_tAddress_ans.setText(teacherProfileDisplayResponse.getStaffAddress().toString());
                        tv_tMobile_ans.setText(teacherProfileDisplayResponse.getStaffMobileNo().toString());
                        tv_tExperience_ans.setText(teacherProfileDisplayResponse.getStaffEducation().toString());
                        tv_tClassteacher_ans.setText(teacherProfileDisplayResponse.getClassTeacher().toString());
                        tv_tdate_ans.setText(teacherProfileDisplayResponse.getStaffJoiningDate().toString());
                    }
            }


        }

            @Override
            public void onFailure(Call<TeacherProfileDisplayResponse> call, Throwable t) {

            }

            });
    }


}
