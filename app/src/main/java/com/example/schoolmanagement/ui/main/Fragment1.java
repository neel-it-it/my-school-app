package com.example.schoolmanagement.ui.main;

import android.content.Intent;
import android.icu.text.CaseMap;
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

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.schoolmanagement.MainActivity;
import com.example.schoolmanagement.R;
import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.forgot_password;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.student_login_response.LoginResponse;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.icu.text.CaseMap.*;
import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class Fragment1 extends Fragment {

    private EditText uid;

    private EditText pass;
    private TextView fp;
    private Button button;
    float v=0;
    AwesomeValidation awesomeValidation;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.fragment1_layout,container,false);

        pass=root.findViewById(R.id.pass);
        uid=root.findViewById(R.id.uid);
        fp=root.findViewById(R.id.fp);
        button=root.findViewById(R.id.button);

        //awesomeValidation.addValidation(getActivity(), R.id.uid, "[a-zA-Z\\s]+", R.string.err_name);

   fp.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           startActivity(new Intent(getActivity(), forgot_password.class));
       }
   });



        pass.setTranslationX(800);

        uid.setTranslationX(800);
        fp.setTranslationX(800);
        button.setTranslationX(800);

        pass.setAlpha(v);

        uid.setAlpha(v);
        fp.setAlpha(v);
        button.setAlpha(v);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
                if(TextUtils.isEmpty(uid.getText().toString())) {
                    Toast.makeText(getActivity(), "Please enter student id", Toast.LENGTH_SHORT).show();
                    uid.setError("Please enter student id");
                }
                else if(TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(getActivity(), "Please enter student password", Toast.LENGTH_SHORT).show();
                    pass.setError("Please enter student password");
                } else {
                    callApi(uid.getText().toString(),pass.getText().toString());
                }


            }
        });


        uid.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        fp.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }

    public void callApi(String stu_id, String pass) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        apiInterface.login(stu_id, pass).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful() && response.body() != null) {
                    LoginResponse loginResponse = response.body();

                    if(loginResponse.getSuccess() == 1) {
                        PrefUtil.putbooleanPref(Common.isLoggedIn, true, getActivity());
                        PrefUtil.putstringPref(Common.userRole, "S", getActivity());
                        PrefUtil.putstringPref(Common.userId, stu_id, getActivity());
                        //next activity
                       Intent intent=new Intent(getActivity(),MainActivity.class);

                        startActivity(intent);
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                        bottomSheetDialog.setContentView(R.layout.bottomsheet_massage);
                        bottomSheetDialog.setCanceledOnTouchOutside(false);
                        bottomSheetDialog.setDismissWithAnimation(true);
                        bottomSheetDialog.show();
                        //startActivity(new Intent(getActivity(), MainActivity.class));
                    //    Toast.makeText(getActivity(), "Successful", Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
