package com.ifsc.packagemanager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    int myResource;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        convertView = inflater.inflate(myResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tvNome = convertView.findViewById(R.id.textView);

        LinearLayout layoutVertical = convertView.findViewById(R.id.linearLayoutV);

        ApplicationInfo appInfo = getItem(position);

        if (appInfo == null) return convertView;

        tvNome.setText(appInfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(appInfo.loadIcon(getContext().getPackageManager()));

        TextView tv = new TextView(getContext());

        tv.setText(appInfo.packageName);

        layoutVertical.addView(tv);

        TextView tvFlag = new TextView(getContext());

        tvFlag.setText(Integer.toBinaryString(appInfo.flags));

        layoutVertical.addView(tvFlag);

        return convertView;
    }
}
