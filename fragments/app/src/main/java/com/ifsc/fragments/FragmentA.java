package com.ifsc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {
    Button buttonSend;
    EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        buttonSend = v.findViewById(R.id.buttonSend);
        editText = v.findViewById(R.id.editTextMsg);

        buttonSend.setOnClickListener(v1 -> {
            FragmentB fragmentB = new FragmentB();

            Bundle b = new Bundle();
            b.putString("msg", editText.getText().toString());
            fragmentB.setArguments(b);

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, fragmentB);
            transaction.commit();

        });

        return v;
    }
}