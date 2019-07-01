package com.example.uipl.serviceexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BindingActivity extends AppCompatActivity {
    private   TextView timeStampText;
    private   Button printTimeStamp;
    private  Button stopService;
    BoundService mBoundService;
    Boolean mServiceBound = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_activity);
        timeStampText = (TextView)findViewById(R.id.timestamp_text);
         printTimeStamp = (Button) findViewById(R.id.print_timestamp);
        stopService   =  (Button)findViewById(R.id.stop_service);
    }
    @Override
    protected void onResume() {
        printTimeStamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mServiceBound) {
                    // get applicationcontext Return the context for all activities running in application
                    Toast.makeText(getApplicationContext(),"print timestamp",Toast.LENGTH_SHORT).show();
                    timeStampText.setText(mBoundService.getTimestamp());
                }
            }
        });
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"service stop",Toast.LENGTH_SHORT).show();
                if (mServiceBound)
                {
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                }
                Intent intent = new Intent(BindingActivity.this,
                        BoundService.class);
                stopService(intent);
            }
        });
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,BoundService.class);
        startService(intent);
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
           mBoundService = myBinder.getService();
            mServiceBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }
    };
}
