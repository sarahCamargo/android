package com.ifsc.layouts;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTelaProgramatica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout layout = new LinearLayout(getApplicationContext());

        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        layout.setLayoutParams(params);

        final TextView text = new TextView(getApplicationContext());

        text.setText("Olá Mundo!");

        final Button button = new Button(getApplicationContext());

        button.setText("Clique aqui");

        layout.addView(text);
        layout.addView(button);

        setContentView(layout);
    }
}