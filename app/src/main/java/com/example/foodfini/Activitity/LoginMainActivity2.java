package com.example.foodfini.Activitity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodfini.Model.RegisterModel;
import com.example.foodfini.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginMainActivity2 extends AppCompatActivity {


    TextView registertext;
    EditText nameEditTextView, PasswordTextView, emailTextView;
    private FirebaseDatabase mdatabase;
    DatabaseReference databaseReference;

    private FirebaseAuth mauth;
    String mname, mpassword, memail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main2);

        nameEditTextView = findViewById(R.id.editTextTextPersonName2);
        emailTextView = findViewById(R.id.editTextTextPersonemail);
        PasswordTextView = findViewById(R.id.editTextTextPersonPassword);



        registertext = findViewById(R.id.editTextTextPersonsignin);

        mauth = FirebaseAuth.getInstance();


        registertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mname = nameEditTextView.getText().toString();
                memail = emailTextView.getText().toString();
                mpassword = PasswordTextView.getText().toString();


                mdatabase = FirebaseDatabase.getInstance();
                databaseReference = mdatabase.getReference().child("student");


                mauth.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if(task.isSuccessful()){

                            String uid = mauth.getCurrentUser().getUid();
                            RegisterModel model = new RegisterModel(uid,mname,mpassword, memail);

                            databaseReference.child(uid).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(LoginMainActivity2.this, "success", Toast.LENGTH_SHORT).show();

                                    }else {
                                        Toast.makeText(LoginMainActivity2.this, "error", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });

                        }
                        else {
                            Toast.makeText(LoginMainActivity2.this, "try again", Toast.LENGTH_SHORT).show();
                        }

                    }
                });





            }
        });
    }
}