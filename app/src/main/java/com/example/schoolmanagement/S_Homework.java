package com.example.schoolmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagement.ui.home.HomeFragment;

public class S_Homework extends AppCompatActivity {

    private Spinner classSpinner;
    private Spinner divSpinner;
    String selectedClass, selectedDiv, selectedsub;
    private Spinner subSpinner;
    private Button btn_file;
    private Button btn_upload;
    Intent myFileIntent;
    private TextView tv_path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s__homework);
        classSpinner = findViewById(R.id.classSpinner);
        divSpinner = findViewById(R.id.divSpinner);
        subSpinner = findViewById(R.id.subSpinner);
        tv_path = findViewById(R.id.tv_path);

        btn_file = findViewById(R.id.btn_file);
        btn_file = findViewById(R.id.btn_file);
      /*  btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(S_Homework.this, HomeFragment.class);
                startActivity(i);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.ly,new  UsinfoFragment());
                transaction.commit();
            }
        });*/
        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                myFileIntent.addCategory(Intent.CATEGORY_OPENABLE);
                myFileIntent.setType("application/pdf");
                startActivityForResult(myFileIntent, 10);
            }
        });
        btn_upload = findViewById(R.id.btn_upload);




        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedClass = classSpinner.getSelectedItem().toString();
                switch (selectedClass) {
                    case "Class 1":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1)));

                        break;

                    case "Class 2":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2)));
                        break;

                    case "Class 3":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3)));
                        break;

                    case "Class 4":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4)));
                        break;

                    case "Class 5":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_5)));
                        break;

                    case "Class 6":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_6)));
                        break;

                    case "Class 7":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_7)));
                        break;

                    case "Class 8":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_8)));
                        break;

                    case "Class 9":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_9)));
                        break;

                    case "Class 10":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_10)));
                        break;
                }

                //set divSpinner Visibility to Visible
                divSpinner.setVisibility(View.VISIBLE);
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedDiv = divSpinner.getSelectedItem().toString();

                switch (selectedDiv) {
                    case "Class 1":
                        // assigning div item list defined in XML to the div Spinner
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1_subject)));

                        break;

                    case "Class 2":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2_subject)));
                        break;

                    case "Class 3":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3_subject)));
                        break;

                    case "Class 4":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4_subject)));
                        break;

                    case "Class 5":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_5_subject)));
                        break;

                    case "Class 6":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_6_subject)));
                        break;

                    case "Class 7":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_7_subject)));
                        break;

                    case "Class 8":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_8_subject)));
                        break;

                    case "Class 9":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_9_subject)));
                        break;

                    case "Class 10":
                        subSpinner.setAdapter(new ArrayAdapter<String>(S_Homework.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_10_subject)));
                        break;
                }

                subSpinner.setVisibility(View.VISIBLE);
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        subSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedsub = subSpinner.getSelectedItem().toString();
               // Toast.makeText(S_Homework.this, "\n Class: \t " + selectedClass +
                    //    "\n Div: \t" + selectedDiv + "\n Subject: \t", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    tv_path.setText(path);
                }
                break;
        }
    }
}