package com.ifsc.imc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MessageActivity extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView text = findViewById(R.id.textView2);

        String mensagem = Objects.requireNonNull(getIntent().getExtras()).getString("msg");

        text.setText(mensagem);


        button = findViewById(R.id.button2);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

    }
}