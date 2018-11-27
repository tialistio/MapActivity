package com.example.user.mapactivity;

import android.Manifest;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        String locationProvider = LocationManager.GPS_PROVIDER;

        //boolean fine= ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        //boolean course = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);

    }

    @Override
    public void onMapReady(GoogleMap googleMap){

        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        double latitude = 37.5076030;
        double longtitude = 127.026648;
        LatLng LOC = new LatLng(latitude, longtitude);

        mMap.addMarker(new MarkerOptions().position(LOC).title("카페베네신논현짐").snippet("아메리카노 10% 할인").icon(BitmapDescriptorFactory.fromResource(R.drawable.coffe)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LOC));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));



    }
}
