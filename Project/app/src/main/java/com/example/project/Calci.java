package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Calci extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3,b4,b5;
    TextToSpeech tts;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);
        e1=(EditText) findViewById(R.id.editText6);
        e2=(EditText) findViewById(R.id.editText7);
        b1=(Button) findViewById(R.id.button17);
        b2=(Button) findViewById(R.id.button18);
        b3=(Button) findViewById(R.id.button19);
        t1=(TextView)findViewById(R.id.textView2);
        b4=(Button) findViewById(R.id.button20);
        b5=(Button) findViewById(R.id.button21);
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate(0.8f);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1+i2;
                String s3=i3.toString();
                t1.setText(s3);
                tts.speak("The result is"+s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1-i2;
                String s3=i3.toString();
                t1.setText(s3);
                tts.speak("The result is"+s3,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1*i2;
                String s3=i3.toString();
                t1.setText(s3);
                tts.speak("The result is"+s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1/i2;
                String s3=i3.toString();
                t1.setText(s3);
                tts.speak("The result is"+s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Calci.this,Third.class);
                startActivity(i);
                finish();
            }
        });


    }
}