package com.ifsc.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonFa, buttonFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFa = findViewById(R.id.buttonFragmentA);
        buttonFb = findViewById(R.id.buttonFragmentB);

        buttonFa.setOnClickListener(this);
        buttonFb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;

        if (v.getId() == R.id.buttonFragmentA) {
            fragment = new FragmentA();
        } else if (v.getId() == R.id.buttonFragmentB) {
            fragment = new FragmentB();
        } else {
            throw new IllegalStateException("Unexpected value: " + v.getId());
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}