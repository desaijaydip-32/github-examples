package com.example.foodfini.Activitity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodfini.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                 startActivity(new Intent(SplashScreenActivity2.this, spashActivity.class));
            }
        },500);
    }
}