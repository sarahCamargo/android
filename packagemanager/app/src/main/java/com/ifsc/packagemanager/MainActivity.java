package com.ifsc.packagemanager;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        lv = findViewById(R.id.listview);
        pm = getPackageManager();

        List<ApplicationInfo> appsInfo = new ArrayList<>();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);

        resolveInfos.forEach(resolveInfo -> {
            appsInfo.add(resolveInfo.activityInfo.applicationInfo);
        });

        AppAdapter adapter = new AppAdapter(this, R.layout.item_app, appsInfo);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo appClicked = (ApplicationInfo) parent.getItemAtPosition(position);

                Intent i = pm.getLaunchIntentForPackage(appClicked.packageName);

                //caso nao tenha so avisa o usuario
                
                startActivity(i);
            }
        });
    }
}