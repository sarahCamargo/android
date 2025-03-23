package com.ifsc.imc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setExtras();

        Button voltarButton = findViewById(R.id.voltarButton);

        voltarButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void setExtras() {
        TextView nome = findViewById(R.id.nomeText);
        TextView peso = findViewById(R.id.pesoText);
        TextView altura = findViewById(R.id.alturaText);
        TextView imc = findViewById(R.id.imcText);
        TextView mensagem = findViewById(R.id.mensagemText);
        ImageView image = findViewById(R.id.imageView2);

        IMCInfo imcInfo = (IMCInfo) getIntent().getSerializableExtra("imcInfo");

        if (imcInfo != null) {
            nome.append(imcInfo.getNome());
            peso.append(imcInfo.getPeso());
            altura.append(imcInfo.getAltura());
            imc.append(imcInfo.getImc());
            mensagem.setText(imcInfo.getMensagem());
            image.setImageResource(imcInfo.getImagem());
        }
    }
}