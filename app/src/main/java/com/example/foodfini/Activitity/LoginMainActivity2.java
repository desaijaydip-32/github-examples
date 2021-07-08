package com.example.foodfini.Activitity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodfini.R;

public class LoginMainActivity2 extends AppCompatActivity {



    TextView registertext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main2);



        registertext = findViewById(R.id.editTextTextPersonsignin);
        registertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginMainActivity2.this, MainActivity.class));
                finish();
            }
        });
    }
}