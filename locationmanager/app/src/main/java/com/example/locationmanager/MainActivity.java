package com.example.locationmanager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    TextView tvLatitude;
    TextView tvLongitude;

    LocationManager ln;

    MapView mv;

    Boolean track = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Configuration.getInstance().setUserAgentValue("app.locationmanager");

        tvLatitude = findViewById(R.id.textView1);
        tvLongitude = findViewById(R.id.textView2);
        mv = findViewById(R.id.map);
        mv.setOnTouchListener((v, event) -> {
                    track = false;
                    return false;
                }
        );

        ln = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> getLocalizacao());
    }

    public void showLocalizacao(double latitute, double longitude) {
        GeoPoint startPoint = new GeoPoint(latitute, longitude);
        Marker marker = new Marker(mv);
        marker.setTitle("Estamos aqui");
        marker.setPosition(startPoint);

        IMapController controller = mv.getController();

        if (track) {
            controller.setCenter(startPoint);
        }

        controller.setZoom(18.0);

        mv.getOverlays().clear();
        mv.getOverlays().add(marker);

        mv.invalidate();
    }

    public void getLocalizacao() {
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) || (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)) {

            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return;
        }

//        Location location;
//        location = ln.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        ln.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    public final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            tvLatitude.setText(String.valueOf(location.getLatitude()));
            tvLongitude.setText(String.valueOf(location.getLongitude()));

            showLocalizacao(location.getLatitude(), location.getLongitude());
        }
    };
}