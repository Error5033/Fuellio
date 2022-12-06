package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_location);

        String type = getIntent().getExtras().getString("type");
        String latitude = getIntent().getExtras().getString("latitude");
        String longtitude = getIntent().getExtras().getString("longtitude");
        String postalCode = getIntent().getExtras().getString("postalCode");
        String fuelPrice = getIntent().getExtras().getString("fuelPrice");
        String address = getIntent().getExtras().getString("address");
        String dateTime = getIntent().getExtras().getString("date");

        TextView type_txt = findViewById(R.id.typeActivity);
        TextView dateTime_txt = findViewById(R.id.DateTimeActivity);
        TextView latitude_txt = findViewById(R.id.latActivity);
        TextView longtitude_txt = findViewById(R.id.logActivity);
        TextView postalCode_txt = findViewById(R.id.postalCodeActivity);
        TextView address_txt = findViewById(R.id.addressActivity);
        TextView fuelPriceTxt = findViewById(R.id.fuelPriceActivity);


        type_txt.setText(type);
        dateTime_txt.setText(dateTime);
        latitude_txt.setText(latitude);
        longtitude_txt.setText(longtitude);
        postalCode_txt.setText(postalCode);
        address_txt.setText(address);
        fuelPriceTxt.setText(fuelPrice);


        findViewById(R.id.back_arrow).setOnClickListener(v -> {
            finish();
        });

    }
}