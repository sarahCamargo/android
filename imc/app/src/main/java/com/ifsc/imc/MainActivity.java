package com.ifsc.imc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.calcularButton);

        button.setOnClickListener(v -> {

            EditText nome = findViewById(R.id.nomeEdit);
            EditText peso = findViewById(R.id.pesoEdit);
            EditText altura = findViewById(R.id.alturaEdit);

            String imc = calcularIMC(peso.getText().toString(), altura.getText().toString());
            String mensagemImc = getMensagemImc(imc);

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

            intent.putExtra("nome", nome.getText().toString());
            intent.putExtra("peso", peso.getText().toString());
            intent.putExtra("altura", altura.getText().toString());
            intent.putExtra("imc", imc);
            intent.putExtra("mensagemImc", mensagemImc);

            startActivity(intent);
        });
    }

    private String calcularIMC(String peso, String altura) {
        double alturaDb = Double.parseDouble(altura);
        double pesoDb = Double.parseDouble(peso);

        double resultado = pesoDb / (alturaDb * alturaDb);

        DecimalFormat format = new DecimalFormat("#.#");

        return format.format(resultado);
    }

    private String getMensagemImc(String imc) {
        double imcDb = Double.parseDouble(imc);
        if (imcDb < 18.5) {
            return "Abaixo do peso";
        }
        if (imcDb > 18.6 && imcDb < 24.9) {
            return "Peso Ideal. Parabéns!";
        }
        if (imcDb > 25.0 && imcDb < 29.9) {
            return "Levemente acima do peso";
        }
        if (imcDb > 30.0 && imcDb < 34.9) {
            return "Obesidade grau |";
        }
        if (imcDb > 35.0 && imcDb < 39.9) {
            return "Obesidade grau || (severa)";
        }
        return "Obesidade grau ||| (mórbida)";
    }
}