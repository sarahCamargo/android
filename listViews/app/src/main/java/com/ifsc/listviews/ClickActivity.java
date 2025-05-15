package com.ifsc.listviews;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class ClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_click);

        final Bundle extras = getIntent().getExtras();
        TextView mensagem = findViewById(R.id.mensagemText);

        if (extras != null) {
            mensagem.setText(Objects.requireNonNull(extras.get("itemName")).toString());
        } else {
            mensagem.setText(R.string.erro);
        }

        Button button = findViewById(R.id.voltarButton);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}