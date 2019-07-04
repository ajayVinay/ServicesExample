package com.example.uipl.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    // called when the service is being created
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: created");
        Toast.makeText(getApplicationContext(),"created",Toast.LENGTH_SHORT).show();
    }
    // the service is starting due to call to startservice
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: onStartCommand method called  (service started)");
        Toast.makeText(getApplicationContext(),"started service",Toast.LENGTH_SHORT).show();
        SystemClock.sleep(30000); // 30 seconds
        return super.onStartCommand(intent, flags, startId);

        //return START_STICKY;

       // stopSelf();
    }
    // A client is binding to the service with bind Service
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
       // Toast.makeText(getApplicationContext(),"bind component",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onBind: method called ");
        return null;
    }
    // called when all client have unbound with unbind Service
    @Override
    public boolean onUnbind(Intent intent) {
       // Toast.makeText(getApplicationContext(),"onUnbind callled",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onUnbind: called");
        return super.onUnbind(intent);
    }
    //  called when a client is binding  to the service  with bindService
    @Override
    public void onRebind(Intent intent) {
       // Toast.makeText(getApplicationContext(),"Rebind component",Toast.LENGTH_SHORT).show();
        super.onRebind(intent);
    }

    // called when the service is no longer user abd is being destroyed
    // https://github.com/dbhagen/react-native-google-calendar-api
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"destroy or stop service",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy: destroy called (service destroy)");
    }
}
