package com.ifsc.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
            EditText mensagem = findViewById(R.id.editTextText);
            intent.putExtra("msg", mensagem.getText().toString());
            startActivity(intent);
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            //classe anonima
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        Log.d("ciclodevida", "onCreate");
        Toast.makeText(this, getString(R.string.app_name), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() { //visível ao usuário
        Log.d("ciclodevida", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() { //começa a interagir com o usuário
        Log.d("ciclodevida", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() { //está prestes a retomar outra Activity
        Log.d("ciclodevida", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() { //não está mais visível ao usuário
        Log.d("ciclodevida", "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d("ciclodevida", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d("ciclodevida", "onDestroy");
        super.onDestroy();
    }
}