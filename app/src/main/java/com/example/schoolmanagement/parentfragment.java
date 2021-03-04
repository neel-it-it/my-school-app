package com.example.schoolmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class parentfragment extends Fragment {

    private EditText email;
    private EditText pass;
    private TextView fp;
    private Button button;
    private EditText user;
    private EditText uid;
    float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.parentfragment, container, false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        fp = root.findViewById(R.id.fp);
        button = root.findViewById(R.id.button);
        user=root.findViewById(R.id.user);
        uid=root.findViewById(R.id.uid);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        fp.setTranslationX(800);
        button.setTranslationX(800);
        user.setTranslationX(800);
        uid.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        fp.setAlpha(v);
        button.setAlpha(v);
        user.setAlpha(v);
        uid.setAlpha(v);

        user.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        uid.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        fp.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1100).start();
        return root;
    }
}
