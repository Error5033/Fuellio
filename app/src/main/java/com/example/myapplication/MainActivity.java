package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.database.ModelClass;
import com.example.myapplication.database.ViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LocationManager locationManager;
    FusedLocationProviderClient client;
    Context mContext;
    String longtitude, latitude, city, address, type, postalCode, fuelPrice, location;
    Button petrolBtn, dieselBtn, lpgBtn, gpsBtn, saveRecords, viewRecords;
    TextInputEditText postalCodeET;
    TextInputEditText fuelPriceET;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        petrolBtn = findViewById(R.id.petrol);
        dieselBtn = findViewById(R.id.diesel);
        lpgBtn = findViewById(R.id.lpg);
        gpsBtn = findViewById(R.id.gps);
        saveRecords = findViewById(R.id.add);
        postalCodeET = findViewById(R.id.postalCodeET);
        fuelPriceET = findViewById(R.id.fuelPriceET);


        pd = new ProgressDialog(this);
        pd.setMessage("Collecting Data");
        pd.setCancelable(false);

        viewRecords = findViewById(R.id.viewAll);

        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        isLocationEnabled();
        client = LocationServices.getFusedLocationProviderClient(this);

        petrolBtn.setOnClickListener(this);
        dieselBtn.setOnClickListener(this);
        lpgBtn.setOnClickListener(this);
        gpsBtn.setOnClickListener(this);
        saveRecords.setOnClickListener(this);
        viewRecords.setOnClickListener(this);
    }

    private void isLocationEnabled() {

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle("Enable Location");
            alertDialog.setMessage("Your locations setting is not enabled. Please enabled it in settings menu.");
            alertDialog.setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = alertDialog.create();
            alert.show();
        }
    }

    private void getLocation() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            pd.show();
            client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {

                    if (location != null) {
                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        List<Address> addresses;
                        try {
                            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            latitude = String.valueOf(addresses.get(0).getLatitude());
                            longtitude = String.valueOf(addresses.get(0).getLongitude());
                            postalCode = String.valueOf(addresses.get(0).getPostalCode());
                            address = String.valueOf(addresses.get(0).getAddressLine(0));
                            city = String.valueOf(addresses.get(0).getLocality());
                            pd.dismiss();
                            pd.cancel();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.d("getLocation", "onSuccess: exception" + e.getMessage());
                        }
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("getLocation", "onFailure: " + e.getMessage());
                }
            });
        } else {
            askPermission();
        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 101);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }

    private void saveRecords(String type, String lat, String log, String postalCode,String fuelPrice, String address , String city, String dateTime) {
        ViewModel viewmodal = ViewModelProviders.of(this).get(ViewModel.class);
        postalCode = postalCodeET.getText().toString();
        fuelPrice = fuelPriceET.getText().toString();
        viewmodal.insert(new ModelClass(type, lat, log, postalCode,fuelPrice, address, city, dateTime));
        Toast.makeText(this, "New Record Inserted", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.petrol:
                petrolBtn.setEnabled(false);
                dieselBtn.setEnabled(true);
                lpgBtn.setEnabled(true);
                type = "Petrol";
                break;

            case R.id.diesel:
                dieselBtn.setEnabled(false);
                petrolBtn.setEnabled(true);
                lpgBtn.setEnabled(true);
                type = "Diesel";
                break;

            case R.id.lpg:
                lpgBtn.setEnabled(false);
                petrolBtn.setEnabled(true);
                dieselBtn.setEnabled(true);
                type = "LPG";
                break;

            case R.id.gps:
                getLocation();
                break;

            case R.id.add:
                fuelPrice = fuelPriceET.getText().toString();
                postalCode = postalCodeET.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Calendar calendar = Calendar.getInstance();
                String date = dateFormat.format(calendar.getTime());
                saveRecords(type, latitude, longtitude, postalCode,fuelPrice, address, city, date);
                Intent intent = new Intent(this, ShowLocationActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longtitude", longtitude);
                intent.putExtra("postalCode", postalCode);
                intent.putExtra("fuelPrice", fuelPrice);
                intent.putExtra("address", address);
                intent.putExtra("city", city);
                intent.putExtra("date", date);
                startActivity(intent);
                break;

            case R.id.viewAll:
                startActivity(new Intent(this, RecordsActivity.class));
                break;
        }
    }
}