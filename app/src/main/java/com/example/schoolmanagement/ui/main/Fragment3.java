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

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.schoolmanagement.MainActivity;
import com.example.schoolmanagement.R;
import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.parent_login_response.ParentloginResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class Fragment3 extends Fragment {

    private EditText pass;
    private TextView fp;
    private Button button;
    private EditText uid;
    AwesomeValidation awesomeValidation;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment3_layout, container, false);

        awesomeValidation =new AwesomeValidation(BASIC);
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
                    Toast.makeText(getActivity(), "Please enter Mobile no.", Toast.LENGTH_SHORT).show();
                    uid.setError("Please enter Mobile no.");
                }
                else if(uid.getText().toString().length()>10 || uid.getText().toString().length()<10 ){
                    uid.setError("Enter valid 10 digit mobile no.");
                }
                else if(TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(getActivity(), "Please Enter Password", Toast.LENGTH_SHORT).show();
                    pass.setError("Please Enter Password");
                } else {
                    Parentlogin();
                }
            }
        });
        return root;
    }

    private void Parentlogin() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.parentlogin(uid.getText().toString(),pass.getText().toString()).enqueue(new Callback<ParentloginResponse>() {
            @Override
            public void onResponse(Call<ParentloginResponse> call, Response<ParentloginResponse> response) {
                if(response.isSuccessful() && response.body() != null) {
                    ParentloginResponse loginResponse = response.body();

                    if(loginResponse.getSuccess() == 1) {
                        PrefUtil.putbooleanPref(Common.isLoggedIn, true, getActivity());
                        PrefUtil.putstringPref(Common.userRole, "P", getActivity());
                        PrefUtil.putstringPref(Common.userId,uid.getText().toString(), getActivity());
                        //next activity
                        Intent intent=new Intent(getActivity(),MainActivity.class);
                        //next activity
                      //  Intent intent=new Intent(getActivity(),MainActivity.class).putExtra("role","P");
                        startActivity(intent);
                        //startActivity(new Intent(getActivity(), MainActivity.class));
                        Toast.makeText(getActivity(), "Successful", Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<ParentloginResponse> call, Throwable t) {

            }


        });
    }
}
