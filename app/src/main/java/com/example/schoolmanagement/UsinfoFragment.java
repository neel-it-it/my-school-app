package com.example.schoolmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.stu_profile_display.StuProfileDisplayResponse;
import com.example.schoolmanagement.response.stu_profile_update.StuProfileUpdateResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsinfoFragment extends Fragment {


    private Button btn_update;
    private EditText et_name;
    private EditText et_address;
    private EditText et_cnum;
    private EditText et_email;
    private EditText et_mother;
    private EditText et_father;

    public UsinfoFragment() {
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

       View view = inflater.inflate(R.layout.fragment_usinfo, container, false);
        btn_update = view.findViewById(R.id.btn_update);
        et_name=view.findViewById(R.id.et_name);
        et_father=view.findViewById(R.id.et_father);
        et_mother=view.findViewById(R.id.et_mother);
        et_email=view.findViewById(R.id.et_email);
        et_cnum=view.findViewById(R.id.et_cnum);
        et_address=view.findViewById(R.id.et_address);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                studentupdate();
                Toast.makeText(getActivity(), ""+MainActivity.userid1, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        studentprofile();

        return  view;
    }

    private void studentprofile() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.stuprofiledisplay(PrefUtil.getstringPref(Common.userId,getActivity())).enqueue(new Callback<StuProfileDisplayResponse>() {
            @Override
            public void onResponse(Call<StuProfileDisplayResponse> call, Response<StuProfileDisplayResponse> response) {
                if (response.isSuccessful() && response.body()!=null) {

                    StuProfileDisplayResponse stuProfileDisplayResponse = response.body();
                    if(stuProfileDisplayResponse.getSuccess() == 1) {
                        et_name.setText(stuProfileDisplayResponse.getStuName().toString());
                        et_email.setText(stuProfileDisplayResponse.getStuEmailId().toString());
                        et_address.setText(stuProfileDisplayResponse.getStuAddress().toString());
                        et_father.setText(stuProfileDisplayResponse.getFatherName().toString());
                        et_mother.setText(stuProfileDisplayResponse.getMotherName().toString());
                        et_cnum.setText(stuProfileDisplayResponse.getStuMobileNo().toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<StuProfileDisplayResponse> call, Throwable t) {

            }
        });
    }

    private void studentupdate() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("student_id",PrefUtil.getstringPref(Common.userId,getActivity()).toString())
                .addFormDataPart("stu_name",et_name.getText().toString())
                .addFormDataPart("father_name",et_father.getText().toString())
                .addFormDataPart("mother_name",et_mother.getText().toString())
                .addFormDataPart("stu_address",et_address.getText().toString())
                .addFormDataPart("stu_email_id",et_email.getText().toString())
                .addFormDataPart("stu_mobile_no",et_cnum.getText().toString())
                .build();

         apiInterface.stuprofileupdate(requestBody).enqueue(new Callback<StuProfileUpdateResponse>() {
             @Override
             public void onResponse(Call<StuProfileUpdateResponse> call, Response<StuProfileUpdateResponse> response) {
                 if (response.isSuccessful() && response.body()!=null){
                     StuProfileUpdateResponse stuProfileUpdateResponse = response.body();
                     Toast.makeText(getActivity(), ""+stuProfileUpdateResponse.getSuccess(), Toast.LENGTH_SHORT).show();
                     if(stuProfileUpdateResponse.getSuccess() == 1){
                         Toast.makeText(getActivity(),"Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                     }

                     else {
                         Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                     }
                 }
             }

             @Override
             public void onFailure(Call<StuProfileUpdateResponse> call, Throwable t) {

             }
         });
    }

}