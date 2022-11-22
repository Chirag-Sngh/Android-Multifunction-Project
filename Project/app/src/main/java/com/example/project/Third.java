package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Third extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1=(Button) findViewById(R.id.button6);
        b2=(Button) findViewById(R.id.button7);
        b3=(Button) findViewById(R.id.button8);
        b4=(Button) findViewById(R.id.button9);
        b5=(Button) findViewById(R.id.button10);
        b6=(Button) findViewById(R.id.button11);
        b7=(Button) findViewById(R.id.button12);
        b8=(Button) findViewById(R.id.button13);
        b9=(Button) findViewById(R.id.button14);
        b10=(Button) findViewById(R.id.button15);
        b11=(Button) findViewById(R.id.button16);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Third.this,Calci.class);
                startActivity(i);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Third.this,Torch.class);
                startActivity(j);
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Third.this,Browser.class);
                startActivity(k);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(Third.this,Video.class);
                startActivity(l);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m=new Intent(Third.this,OTP.class);
                startActivity(m);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=new Intent(Third.this,realtimedb.class);
                startActivity(n);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o=new Intent(Third.this,gmaillogin.class);
                startActivity(o);
                finish();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p=new Intent(Third.this,TiltAll.class);
                startActivity(p);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q=new Intent(Third.this,Quiz1.class);
                startActivity(q);
                finish();
            }
        });



    }
}