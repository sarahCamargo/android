package com.ifsc.listviews;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] frutas = new String[]{"Pera", "Uva", "Maçã", "Banana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                frutas);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            final String item = ((TextView) view).getText().toString();

            Intent intent = new Intent(this, ClickActivity.class);

            intent.putExtra("itemName", item);

            startActivity(intent);
        });

    }
}