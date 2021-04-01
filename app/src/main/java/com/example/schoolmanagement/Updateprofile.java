package com.example.schoolmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.teacher_profile_display.TeacherProfileDisplayResponse;
import com.example.schoolmanagement.response.teacher_profile_update.TeacherProfileUpdateResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Updateprofile extends AppCompatActivity
{

    private Button btn;
    private EditText ep1;
    private EditText ep2;
    private EditText ep3;
    private EditText ep4;
    private EditText ep5;
    private EditText ep6;
    String uid;
    private TextView ep7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        ep1 =findViewById(R.id.ep1);
        ep3 =findViewById(R.id.ep3);
        ep4 =findViewById(R.id.ep4);
        ep5 =findViewById(R.id.ep5);
        ep6 =findViewById(R.id.ep6);
        ep7 = findViewById(R.id.ep7);
        btn = findViewById(R.id.btn);
        uid=getIntent().getStringExtra("uid");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staffupdate();
                Toast.makeText(Updateprofile.this, ""+uid, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Updateprofile.this, MainActivity.class));

            }
        });
        staffprofile();
    }

    private void staffprofile() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.teacherprofiledisplay(PrefUtil.getstringPref(Common.userId,Updateprofile.this).toString()).enqueue(new Callback<TeacherProfileDisplayResponse>() {
            @Override
            public void onResponse(Call<TeacherProfileDisplayResponse> call, Response<TeacherProfileDisplayResponse> response) {
                if (response.isSuccessful() && response.body()!=null) {

                    TeacherProfileDisplayResponse teacherProfileDisplayResponse = response.body();
                    if(teacherProfileDisplayResponse.getSuccess() == 1) {
                        ep1.setText(teacherProfileDisplayResponse.getStaffName().toString());
                        ep3.setText(teacherProfileDisplayResponse.getStaffEmail().toString());
                       ep4.setText(teacherProfileDisplayResponse.getStaffAddress().toString());
                        ep5.setText(teacherProfileDisplayResponse.getStaffMobileNo().toString());
                       ep6.setText(teacherProfileDisplayResponse.getClassTeacher().toString());
                        ep7.setText(teacherProfileDisplayResponse.getStaffEducation().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<TeacherProfileDisplayResponse> call, Throwable t) {

            }
        });
    }

    private void staffupdate() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        RequestBody requestBody= new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("staff_id", PrefUtil.getstringPref(Common.userId,this).toString())
                .addFormDataPart("staff_name",ep1.getText().toString())
                .addFormDataPart("staff_email",ep3.getText().toString())
                .addFormDataPart("staff_address",ep4.getText().toString())
                .addFormDataPart("staff_mobile_no",ep5.getText().toString())
                .addFormDataPart("staff_education",ep7.getText().toString())
                .addFormDataPart("class_teacher",ep6.getText().toString())
                .build();

            apiInterface.teacherprofileupdate(requestBody).enqueue(new Callback<TeacherProfileUpdateResponse>() {
                @Override
                public void onResponse(Call<TeacherProfileUpdateResponse> call, Response<TeacherProfileUpdateResponse> response) {
                    if (response.isSuccessful() && response.body()!=null){
                        TeacherProfileUpdateResponse teacherProfileUpdateResponse = response.body();
                       // Toast.makeText(Updateprofile.this, ""+teacherProfileUpdateResponse.getSuccess(), Toast.LENGTH_SHORT).show();
                        if(teacherProfileUpdateResponse.getSuccess() == 1){
                            Toast.makeText(Updateprofile.this,"Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            Toast.makeText(Updateprofile.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<TeacherProfileUpdateResponse> call, Throwable t) {

                }
            });
    }
}