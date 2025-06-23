package com.ifsc.launcher;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview_apps);

        PackageManager packageManager = getPackageManager();

        List<ApplicationInfo> applicationInfos = new ArrayList<>();

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(mainIntent, 0);

        resolveInfos.forEach(resolveInfo -> {
            applicationInfos.add(resolveInfo.activityInfo.applicationInfo);
        });

        AppAdapter appAdapter = new AppAdapter(this, R.layout.item_lista, applicationInfos);
        listView.setAdapter(appAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
            String packageName = applicationInfo.packageName;
            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

            Intent intent = packageManager.getLaunchIntentForPackage(packageName);
            if (intent != null && packageName != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
            }
        });

    }
}