package com.ifsc.imc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            TextView nome = findViewById(R.id.nomeText);
            TextView peso = findViewById(R.id.pesoText);
            TextView altura = findViewById(R.id.alturaText);
            TextView imc = findViewById(R.id.imcText);
            TextView mensagem = findViewById(R.id.mensagemText);

            nome.append(extras.getString("nome"));
            peso.append(extras.getString("peso"));
            altura.append(extras.getString("altura"));
            imc.append(extras.getString("imc"));
            mensagem.setText(extras.getString("mensagemImc"));
        }
    }
}