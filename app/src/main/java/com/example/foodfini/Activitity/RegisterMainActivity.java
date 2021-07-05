package com.example.foodfini.Activitity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodfini.R;

public class RegisterMainActivity extends AppCompatActivity {


    TextView registertexview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);

        registertexview = findViewById(R.id.textView11);
        registertexview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterMainActivity.this, LoginMainActivity2.class));
            }
        });
    }
}