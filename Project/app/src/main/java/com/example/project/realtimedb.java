package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class realtimedb extends AppCompatActivity {
    EditText e1;
    Button b1;
    CountryCodePicker ccp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtimedb);
        e1=(EditText) findViewById(R.id.editText11);
        b1=(Button) findViewById(R.id.button33);
        ccp2=(CountryCodePicker) findViewById(R.id.ccp2);
        ccp2.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(realtimedb.this,realtimedb2.class);
                i.putExtra("mobile",ccp2.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });

    }
}