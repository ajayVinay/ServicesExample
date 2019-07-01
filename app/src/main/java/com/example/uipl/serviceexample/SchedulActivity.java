package com.example.uipl.serviceexample;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SchedulActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";

    Button  btnschedule,btncanceljob;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedul_activity);
        btnschedule =(Button)findViewById(R.id.btnschedule);
        btncanceljob =(Button)findViewById(R.id.btncanceljob);
        btnschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName  componentName = new ComponentName(SchedulActivity.this,ExampleJobService.class);
                JobInfo   jobInfo = new JobInfo.Builder(123,componentName)
                        .setRequiresCharging(true)
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                        .setPersisted(false)
                        .setPeriodic(15*60*1000)
                        .build();
                JobScheduler scheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
                int resultCode =    scheduler.schedule(jobInfo);
                if (resultCode == scheduler.RESULT_SUCCESS) {
                    Log.d(TAG, "Job Scheduled");
                }
                else {
                    Log.d(TAG, "Job Scheduling failed");
                }
            }
        });

        btncanceljob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JobScheduler jscheduler =(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
                jscheduler.cancel(123);
                Log.d(TAG, "Job Cancelled");

            }
        });
    }
}
