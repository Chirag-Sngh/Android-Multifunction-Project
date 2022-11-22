package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz4 extends AppCompatActivity {
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        t1=(TextView) findViewById(R.id.textView6);
        b1=(Button) findViewById(R.id.button45);
        t1.setText("Score is"+Quiz1.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x=new Intent(Quiz4.this,Third.class);
                startActivity(x);
                finish();
            }
        });
    }
}