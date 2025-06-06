package com.ifsc.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterNota extends ArrayAdapter<Nota> {

    int myRes;

    public AdapterNota(@NonNull Context context, int resource, @NonNull List<Nota> objects) {
        super(context, resource, objects);
        myRes = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View v = layoutInflater.inflate(myRes, parent, false);

        Nota notas = getItem(position);

        TextView tv = v.findViewById(android.R.id.text1);

        tv.setText(notas.getNota());

        return v;
    }
}
