package com.example.schoolmanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.schoolmanagement.helper.Common;
import com.example.schoolmanagement.helper.PrefUtil;
import com.example.schoolmanagement.ui.main.Fragment1;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationSubMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {

    public static String userid1;
    public static String role1;
    private AppBarConfiguration mAppBarConfiguration;

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //String userid=getIntent().getStringExtra("userid");
        //String role=getIntent().getStringExtra("role");
        userid1=PrefUtil.getstringPref(Common.userId, this);
        String str_role= PrefUtil.getstringPref(Common.userRole, this);
        Toast.makeText(this, ""+str_role, Toast.LENGTH_SHORT).show();
        //gp1=findViewById(R.id.gp1);



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        MenuItemHoverListener action_logout = findViewById(R.id.action_logout);
        Menu nav_menu = navigationView.getMenu();

        if (str_role.equals("S"))
        {
            Toast.makeText(this, "Hello student", Toast.LENGTH_SHORT).show();
            nav_menu.findItem(R.id.nav_home).setVisible(true);
            nav_menu.setGroupVisible(R.id.gp1,true);
            nav_menu.setGroupVisible(R.id.gp2,false);


        }
        else if (str_role.equals("T"))
        {
            Toast.makeText(this, "Hello Teacher", Toast.LENGTH_SHORT).show();
            nav_menu.findItem(R.id.nav_home).setVisible(true);
            nav_menu.setGroupVisible(R.id.gp1,false);
            nav_menu.setGroupVisible(R.id.gp2,true);
        }
        else if (str_role.equals("P"))
        {
            Toast.makeText(this, "Hello Parent", Toast.LENGTH_SHORT).show();
            nav_menu.findItem(R.id.nav_home).setVisible(true);
            nav_menu.setGroupVisible(R.id.gp1,true);
            nav_menu.setGroupVisible(R.id.gp2,false);
        }
        else
        {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_student, R.id.nav_about_us, R.id.attendanceFragment , R.id.homeworkFragment , R.id.resultFragment , R.id.timetableFragment , R.id.receiptFragment , R.id.eventFragment,R.id.communicationFragment,R.id.busrFragment,R.id.syllabus_CoverageFragment,R.id.teacherinfoFragment,R.id.add_AttendanceFragment,R.id.add_HomeworkFragment,R.id.add_ResultFragment,R.id.add_TimetableFragment,R.id.add_SyllabuscoverageFragment,R.id.add_EventFragment,R.id.add_ReceiptFragment,R.id.home1,
              //  R.id.student1
                R.id.about_us1
                ,R.id.teacherinfoFragment1
                ,R.id.busrFragment1)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        BottomNavigationView bottom_nav_view = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottom_nav_view, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_logout:
                PrefUtil.removeString(Common.userId,MainActivity.this);
                PrefUtil.removeString(Common.userRole,MainActivity.this);
                PrefUtil.removeBoolean(Common.isLoggedIn,MainActivity.this);
                PrefUtil.clearPreference(MainActivity.this);
                Intent i = new Intent(MainActivity.this, Login2.class);
                startActivity(i);
                finish();
                break;

            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}