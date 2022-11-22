package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class OTP3 extends AppCompatActivity {
    Button b1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp3);
        b1=(Button) findViewById(R.id.button30);
        firebaseAuth=FirebaseAuth.getInstance();

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firebaseAuth.signOut();
                    Intent i=new Intent(OTP3.this,OTP.class);
                }


        });
    }
}