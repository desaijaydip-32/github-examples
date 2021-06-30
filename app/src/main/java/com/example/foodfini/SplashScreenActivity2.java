package com.example.foodfini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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

                 startActivity(new Intent(SplashScreenActivity2.this, MainActivity.class));
            }
        },500);
    }
}