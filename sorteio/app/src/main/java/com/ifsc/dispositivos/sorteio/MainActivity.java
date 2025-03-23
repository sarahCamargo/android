package com.ifsc.dispositivos.sorteio;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sortear = findViewById(R.id.sortearButton);

        sortear.setOnClickListener(v -> {
            EditText numA = findViewById(R.id.numAEdit);
            EditText numB = findViewById(R.id.numBEdit);


            if (numA != null && numB != null) {
                Random random = new Random();
                TextView text = findViewById(R.id.numSorteadoText);

                int numAInt = Integer.parseInt(numA.getText().toString());
                int numBInt = Integer.parseInt(numB.getText().toString());


                if (numAInt == numBInt) {
                    text.setText("Nenhum intervalo selecionado");
                    Toast.makeText(this, "Não é possível sortear em um intervalo de números iguais.", LENGTH_LONG).show();
                    return;
                }

                if (numAInt > numBInt) {
                    text.setText("Nenhum intervalo selecionado");
                    Toast.makeText(this, "Intervalo incorreto. Digite o menor número no primeiro campo.", LENGTH_LONG).show();
                    return;
                }

                int numSorteado = random.nextInt(numBInt - numAInt + 1) + numAInt;

                text.setText("Número sorteado: ");
                text.append(String.valueOf(numSorteado));
            }
        });
    }
}