package com.ifsc.layouts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        final Button send = findViewById(R.id.sendButton);

        send.setOnClickListener(v -> {
            final TextView name = findViewById(R.id.editTextNome);
            final TextView email = findViewById(R.id.editTextEmail);
            final RadioGroup radioGroup = findViewById(R.id.radioGroupCourses);

            showFields(name, email, radioGroup);
            cleanFields(name, email, radioGroup);
        });
    }

    private void showFields(TextView name, TextView email, RadioGroup radioGroup) {
        final int selectedCourse = radioGroup.getCheckedRadioButtonId();
        String selectedCourseText = "";

        if (selectedCourse != -1) {
            RadioButton radioButtonSelecionado = findViewById(selectedCourse);
            selectedCourseText = radioButtonSelecionado.getText().toString();
        }

        Toast.makeText(getApplicationContext(), name.getText() + " - " + email.getText() + " - " + selectedCourseText, Toast.LENGTH_LONG).show();
    }

    private void cleanFields(TextView name, TextView email, RadioGroup radioGroup) {
        name.setText("");
        email.setText("");
        radioGroup.clearCheck();
    }
}