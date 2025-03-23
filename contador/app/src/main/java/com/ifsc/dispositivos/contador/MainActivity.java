package com.ifsc.dispositivos.contador;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int cliques = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cliquesText = findViewById(R.id.cliquesText);
        Button contar = findViewById(R.id.contarButton);
        Button resetar = findViewById(R.id.resetarButton);

        contar.setOnClickListener(v -> {
            cliques++;
            cliquesText.setText("Total de Cliques: " + cliques);
        });

        resetar.setOnClickListener(v -> {
            cliques = 0;
            cliquesText.setText("Total de Cliques: " + cliques);
        });
    }
}