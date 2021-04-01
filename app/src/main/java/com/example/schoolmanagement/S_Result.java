package com.example.schoolmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class S_Result extends AppCompatActivity {

    private Spinner classSpinner;
    private Spinner divSpinner;
    String selectedClass, selectedDiv,selectedsub;
    private Button btn_file;
    private Button btn_upload;
    private TextView tv_path;
    Intent myFileIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s__result);
        classSpinner = findViewById(R.id.classSpinner);
        divSpinner = findViewById(R.id.divSpinner);
        tv_path = findViewById(R.id.tv_path);
        btn_file = findViewById(R.id.btn_file);
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
                switch (selectedClass)
                {
                    case "Class 1":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1)));

                        break;

                    case "Class 2":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2)));
                        break;

                    case "Class 3":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3)));
                        break;

                    case "Class 4":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4)));
                        break;

                    case "Class 5":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_5)));
                        break;

                    case "Class 6":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_6)));
                        break;

                    case "Class 7":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_7)));
                        break;

                    case "Class 8":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_8)));
                        break;

                    case "Class 9":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_9)));
                        break;

                    case "Class 10":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Result.this,
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

                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */

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