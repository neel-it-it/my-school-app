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

public class S_Syllabus extends AppCompatActivity {

    private Spinner classSpinner;
    private Spinner divSpinner;
    private TextView tv_path;
    private Button btn_file;
    private Button btn_upload;
    Intent myFileIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s__syllabus);
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
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Syllabus.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1)));

                        break;

                    case "Class 2":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Syllabus.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2)));
                        break;

                    case "Class 3":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Syllabus.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3)));
                        break;

                    case "Class 4":
                        divSpinner.setAdapter(new ArrayAdapter<String>(S_Syllabus.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4)));
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