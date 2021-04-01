package com.example.schoolmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.staff_profile_display.StaffProfileDisplayResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class teacher_info1 extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv_ans1;
    private View v1;
    private TextView tv_ans2;
    private View v2;
    private TextView tv_ans3;
    private View v3;
    private TextView tv_ans4;
    private View v4;
    private TextView tv_ans5;
    private View v5;
    private TextView tv_ans6;
    private View v6;
    private TextView tv_ans7;
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info1);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv_ans1 = findViewById(R.id.tv_ans1);
        v1 = findViewById(R.id.v1);
        tv_ans2 = findViewById(R.id.tv_ans2);
        v2 = findViewById(R.id.v2);
        tv_ans3 = findViewById(R.id.tv_ans3);
        v3 = findViewById(R.id.v3);
        tv_ans4 = findViewById(R.id.tv_ans4);
        v4 = findViewById(R.id.v4);
        tv_ans5 = findViewById(R.id.tv_ans5);
        v5 = findViewById(R.id.v5);
        tv_ans6 = findViewById(R.id.tv_ans6);
        v6 = findViewById(R.id.v6);
        tv_ans7 = findViewById(R.id.tv_ans7);
        btn = findViewById(R.id.btn);
        met_staffprofile();
    }

    private void met_staffprofile() {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        apiInterface.staffprofiledisplay(PrefUtil.getstringPref(Common.userId,teacher_info1.this)).enqueue(new Callback<StaffProfileDisplayResponse>() {
            @Override
            public void onResponse(Call<StaffProfileDisplayResponse> call, Response<StaffProfileDisplayResponse> response) {
                StaffProfileDisplayResponse staffProfileDisplayResponse=response.body();

                if(staffProfileDisplayResponse.getSuccess()==1)
                {
                    tv_ans1.setText(staffProfileDisplayResponse.getStaffName());
                    tv_ans2.setText(staffProfileDisplayResponse.getStaffName());
                    tv_ans3.setText(staffProfileDisplayResponse.getStaffEmail());
                    tv_ans4.setText(staffProfileDisplayResponse.getStaffMobileNo());
                    tv_ans5.setText(staffProfileDisplayResponse.getStaffMobileNo());
                    tv_ans6.setText(staffProfileDisplayResponse.getStaffAddress());
                    tv_ans7.setText(staffProfileDisplayResponse.getStaffMobileNo());


                }

            }

            @Override
            public void onFailure(Call<StaffProfileDisplayResponse> call, Throwable t) {

            }
        });
    }
}