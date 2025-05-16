package com.ifsc.listplanetas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);

        PlanetaAdapter adapter = new PlanetaAdapter(this, R.layout.item_lista, new PlanetaDAO().getPlanetas());

        listView.setAdapter(adapter);
    }
}