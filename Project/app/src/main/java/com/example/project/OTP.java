package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class OTP extends AppCompatActivity {
    EditText e1;
    Button b1,b2;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        b1=(Button) findViewById(R.id.button29);
        b2=(Button)findViewById(R.id.button32);
        e1=(EditText) findViewById(R.id.editText9);
        ccp=(CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OTP.this,OTP2.class);
                i.putExtra("mobile",ccp.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(OTP.this,Third.class);
                startActivity(j);
                finish();
            }
        });
    }
}