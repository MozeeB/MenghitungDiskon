package com.example.mozeeb.menghitungdiskon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import timber.log.Timber;

public class IntroActivity extends Activity {
    private ProgressBar mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show the splash screen
        setContentView(R.layout.activity_intro);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(1000);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
                Timber.e(e.getMessage());
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }
}