package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.window.SplashScreen;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;
import java.util.prefs.Preferences;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);

                    Dexter.withContext(SplashActivity.this)
                            .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                            .withListener(new MultiplePermissionsListener() {

                                @Override
                                public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                    finish();
                                }

                                @Override
                                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {

                                }
                            }).check();
                } catch (
                        InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}