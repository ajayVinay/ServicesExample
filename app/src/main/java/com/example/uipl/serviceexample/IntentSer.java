package com.example.uipl.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class IntentSer extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * //@param name Used to name the worker thread, important only for debugging.
     */

    public IntentSer() {
        super("my intent service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: called");
        Toast.makeText(this,"Intent Service created",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this,"IntentService Started",Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStartCommand: called");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        SystemClock.sleep(30000); // 30 seconds
        Log.d("Service test ", "from the onHandleIntent: method called  ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: call");
        Toast.makeText(this,"IntentService  is onStop",Toast.LENGTH_LONG).show();
    }
}
