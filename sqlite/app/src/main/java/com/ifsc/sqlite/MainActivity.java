package com.ifsc.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button buttonInsere;

    EditText nota;

    ListView listaNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsere = findViewById(R.id.button);
        listaNotas = findViewById(R.id.listView);

        db = openOrCreateDatabase("minhasnotinhas", MODE_PRIVATE, null);

        db.execSQL("" +
                "create table if not exists notas (" +
                " id integer primary key autoincrement," +
                " nota text " +
                ")");

        buttonInsere.setOnClickListener(v -> {
            nota = findViewById(R.id.editTextText);

            insereNota(nota.getText().toString().trim());
        });

        listaNotas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Nota n = (Nota) parent.getItemAtPosition(position);
                db.delete("notas", "id=?", new String[]{String.valueOf(n.getId())});
                carregaNota();
                return false;
            }
        });

        this.carregaNota();
    }

    public void insereNota(String txt) {
        ContentValues cv = new ContentValues();

        cv.put("nota", txt);

        db.insert("notas", null, cv);

        nota.setText("");

        this.carregaNota();
    }

    public void carregaNota() {
        ArrayList<Nota> notas = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from notas", null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int columnId = cursor.getColumnIndex("id");
            int columnNota = cursor.getColumnIndex("nota");

            int id = cursor.getInt(columnId);
            String nota = cursor.getString(columnNota);

            notas.add(new Nota(id, nota));

            cursor.moveToNext();
        }

        AdapterNota adapter = new AdapterNota(this, android.R.layout.simple_list_item_1, notas);

        listaNotas.setAdapter(adapter);

        cursor.close();
    }
}