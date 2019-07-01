package com.example.uipl.serviceexample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button startService,stopService;
    private Intent  serviceIntent;

    private Boolean mStopLoop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startService = (Button)findViewById(R.id.btnstart);
        stopService = (Button)findViewById(R.id.btnstop);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

        serviceIntent = new Intent(MainActivity.this,MyService.class);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnstart:
               // mStopLoop = true;
                this.startService(serviceIntent);
                Toast.makeText(getApplicationContext(),"StartService Button Clicked",Toast.LENGTH_SHORT).show();
                break;

            case  R.id.btnstop:

                this.stopService(serviceIntent);
                Toast.makeText(getApplicationContext(),"StopService Button Clicked",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
