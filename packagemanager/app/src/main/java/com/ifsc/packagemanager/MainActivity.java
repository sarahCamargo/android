package com.ifsc.packagemanager;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PackageManager pm;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pm = getPackageManager();

        List<ApplicationInfo> appsInfo = pm.getInstalledApplications(PackageManager.MATCH_ALL);

        List<ApplicationInfo> appsFiltrados = new ArrayList<>();

        for (ApplicationInfo appInfo : appsInfo) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                appsFiltrados.add(appInfo);
            }
        }

        AppAdapter adapter = new AppAdapter(this, R.layout.item_app, appsFiltrados);

        lv = findViewById(R.id.listview);

        lv.setAdapter(adapter);

    }
}