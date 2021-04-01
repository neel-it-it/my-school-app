package com.example.schoolmanagement.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.schoolmanagement.R;
import com.example.schoolmanagement.UsinfoFragment;
import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.api.ApiInterface;
import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.response.stu_profile_display.StuProfileDisplayResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private Button btn_ustudent_profile;
    private ScrollView sc;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;
    private TextView tv15;
    private TextView tv16;
    private TextView tvrol;
    private TextView tvrid;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        sc = root.findViewById(R.id.sc);
        tv1 = root.findViewById(R.id.tv1);
        tv2 = root.findViewById(R.id.tv2);
        tv3 = root.findViewById(R.id.tv3);
        tv4 = root.findViewById(R.id.tv4);
        tv5 = root.findViewById(R.id.tv5);
        tv6 = root.findViewById(R.id.tv6);
        tv7 = root.findViewById(R.id.tv7);
        tv8 = root.findViewById(R.id.tv8);
        tv9 = root.findViewById(R.id.tv9);
        tv10 = root.findViewById(R.id.tv10);
        tv11= root.findViewById(R.id.tv11);
        tv12= root.findViewById(R.id.tv12);
        tv13= root.findViewById(R.id.tv13);
        tv14= root.findViewById(R.id.tv14);
        tv15= root.findViewById(R.id.tv15);
        tv16= root.findViewById(R.id.tv16);
        tvrol = root.findViewById(R.id.tvrol);
        tvrid = root.findViewById(R.id.tvrid);
        btn_ustudent_profile = root.findViewById(R.id.btn_ustudent_profile);

        btn_ustudent_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GalleryFragment galleryFragment = new GalleryFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
               // manager.beginTransaction().add(R.id.ly,galleryFragment);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.ly,new  UsinfoFragment());
                transaction.commit();
            }
        });

        studentdisplay();

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void studentdisplay() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.stuprofiledisplay(PrefUtil.getstringPref(Common.userId,getActivity())).enqueue(new Callback<StuProfileDisplayResponse>() {
            @Override
            public void onResponse(Call<StuProfileDisplayResponse> call, Response<StuProfileDisplayResponse> response) {
                if (response.isSuccessful() && response.body()!=null)
                {
                    StuProfileDisplayResponse stuProfileDisplayResponse = response.body();
                    if(stuProfileDisplayResponse.getSuccess() == 1){
                        tv2.setText(stuProfileDisplayResponse.getStuName().toString());
                        tv4.setText(stuProfileDisplayResponse.getStuEmailId().toString());
                        tv6.setText(stuProfileDisplayResponse.getStuPassword().toString());
                        tvrid.setText(stuProfileDisplayResponse.getRollNo().toString());
                        tv8.setText(stuProfileDisplayResponse.getStuAddress().toString());
                        tv10.setText(stuProfileDisplayResponse.getFatherName().toString());
                        tv12.setText(stuProfileDisplayResponse.getMotherName().toString());
                        tv14.setText(stuProfileDisplayResponse.getClassId().toString());
                        tv16.setText(stuProfileDisplayResponse.getDivId().toString());

                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StuProfileDisplayResponse> call, Throwable t) {

            }
        });
        
        
        
        
        
        
        
        

    }
}