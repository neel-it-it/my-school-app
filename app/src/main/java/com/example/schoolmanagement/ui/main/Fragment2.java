package com.example.schoolmanagement.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.schoolmanagement.MainActivity;
import com.example.schoolmanagement.R;
import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.teacher_login_response.TeacherloginResponse;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment2 extends Fragment {

    private EditText pass;
    private TextView fp;
    private Button button;

    private EditText uid;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment2_layout, container, false);


        pass = root.findViewById(R.id.pass);
        fp = root.findViewById(R.id.fp);
        button = root.findViewById(R.id.button);

        uid=root.findViewById(R.id.uid);

        pass.setTranslationX(800);
        fp.setTranslationX(800);
        button.setTranslationX(800);
        uid.setTranslationX(800);


        pass.setAlpha(v);
        fp.setAlpha(v);
        button.setAlpha(v);
        uid.setAlpha(v);


        uid.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        fp.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(uid.getText().toString())) {
                    Toast.makeText(getActivity(), "Please enter teacher id", Toast.LENGTH_SHORT).show();
                    uid.setError("Please enter student id");
                } else if(TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(getActivity(), "Please enter student password", Toast.LENGTH_SHORT).show();
                    pass.setError("Please enter student password");
                } else {
                    Teacherlogin();
                }
            }
        });
        return root;


    }

    private void Teacherlogin() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.teacherlogin(uid.getText().toString(),pass.getText().toString()).enqueue(new Callback<TeacherloginResponse>() {
            @Override
            public void onResponse(Call<TeacherloginResponse> call, Response<TeacherloginResponse> response) {
                if(response.isSuccessful() && response.body() != null) {
                    TeacherloginResponse loginResponse = response.body();

                    if(loginResponse.getSuccess() == 1) {
                        PrefUtil.putbooleanPref(Common.isLoggedIn, true, getActivity());
                        PrefUtil.putstringPref(Common.userRole, "T", getActivity());
                        PrefUtil.putstringPref(Common.userId,uid.getText().toString(), getActivity());
                        //next activity
                        Intent intent=new Intent(getActivity(),MainActivity.class);
                        //next activity
                       // Intent intent=new Intent(getActivity(),MainActivity.class).putExtra("role","T").putExtra("uid",uid.getText().toString().trim());
                        startActivity(intent);
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                        bottomSheetDialog.setContentView(R.layout.bottomsheet_massage);
                        bottomSheetDialog.setCanceledOnTouchOutside(false);
                        bottomSheetDialog.setDismissWithAnimation(true);
                        bottomSheetDialog.show();
                        //startActivity(new Intent(getActivity(), MainActivity.class));
                      //  Toast.makeText(getActivity(), "Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Username or password invalid", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        Toast.makeText(getActivity(), "Something went wrong. " + response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<TeacherloginResponse> call, Throwable t) {

            }


        });
    }




}

