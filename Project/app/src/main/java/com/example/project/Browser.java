package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        b1=(Button) findViewById(R.id.button25);
        b2=(Button)findViewById(R.id.button26);
        e1=(EditText) findViewById(R.id.editText8);
        w1=(WebView)findViewById(R.id.webview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                w1.loadUrl(s1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Browser.this,Third.class);
                startActivity(i);
                finish();

            }
        });


    }
}