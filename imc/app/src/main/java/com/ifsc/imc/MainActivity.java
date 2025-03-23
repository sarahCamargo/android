package com.ifsc.imc;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

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

            IMCInfo imcInfo = new IMCInfo();
            imcInfo.setNome(nome.getText().toString());
            imcInfo.setPeso(peso.getText().toString());
            imcInfo.setAltura(altura.getText().toString());

            calcularIMC(imcInfo);

            if (imcInfo.getImc() == null) {
                return;
            }

            setImcMessageAndImage(imcInfo);

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

            intent.putExtra("imcInfo", imcInfo);

            startActivity(intent);
        });
    }

    private void calcularIMC(IMCInfo imcInfo) {
        try {
            double alturaDb = Double.parseDouble(imcInfo.getAltura());
            double pesoDb = Double.parseDouble(imcInfo.getPeso());

            if (pesoDb < 0 || pesoDb > 350) {
                Toast.makeText(this, "Peso inválido. Informe um valor entre 0 até 350kg.", LENGTH_SHORT).show();
                return;
            }

            if (alturaDb < 0 || alturaDb > 3.0) {
                Toast.makeText(this, "Altura inválida. Informe um valor entre 0 até 3m.", LENGTH_SHORT).show();
                return;
            }

            double resultado = pesoDb / (alturaDb * alturaDb);

            DecimalFormat format = new DecimalFormat("#.#");

            imcInfo.setImc(format.format(resultado));
        } catch (NumberFormatException e) {
            Log.e("IMC", "Formato de Peso/Altura inválido", e);
            Toast.makeText(this, "Formato de Peso/Altura inválido", LENGTH_SHORT).show();
        }
    }

    private void setImcMessageAndImage(IMCInfo imcInfo) {
        try {
            double imcDb = Double.parseDouble(imcInfo.getImc());

            if (imcDb < 18.5) {
                imcInfo.setMensagem("Abaixo do peso");
                imcInfo.setImagem(R.drawable.abaixopeso);
                return;
            }
            if (imcDb > 18.6 && imcDb < 24.9) {
                imcInfo.setMensagem("Peso Ideal. Parabéns!");
                imcInfo.setImagem(R.drawable.normal);
                return;
            }
            if (imcDb > 25.0 && imcDb < 29.9) {
                imcInfo.setMensagem("Levemente acima do peso");
                imcInfo.setImagem(R.drawable.sobrepeso);
                return;
            }
            if (imcDb > 30.0 && imcDb < 34.9) {
                imcInfo.setMensagem("Obesidade grau |");
                imcInfo.setImagem(R.drawable.obesidade1);
                return;
            }
            if (imcDb > 35.0 && imcDb < 39.9) {
                imcInfo.setMensagem("Obesidade grau || (severa)");
                imcInfo.setImagem(R.drawable.obesidade2);
                return;
            }
            imcInfo.setMensagem("Obesidade grau ||| (mórbida)");
            imcInfo.setImagem(R.drawable.obesidade3);
        } catch (NumberFormatException e) {
            Log.e("IMC", "Formato de IMC inválido", e);
            Toast.makeText(this, "Formato de IMC inválido", LENGTH_SHORT).show();
        }
    }
}