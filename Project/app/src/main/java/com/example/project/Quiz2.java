package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz2 extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        b1=(Button) findViewById(R.id.button43);
        r1=(RadioButton) findViewById(R.id.radioButton5);
        r2=(RadioButton) findViewById(R.id.radioButton6);
        r3=(RadioButton) findViewById(R.id.radioButton7);
        r4=(RadioButton) findViewById(R.id.radioButton8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r3.isChecked())
                {
                    ++Quiz1.score;
                }
                else
                {
                    --Quiz1.score;
                }
                Intent j=new Intent(Quiz2.this,Quiz693.class);
                startActivity(j);
                finish();
            }
        });

    }
}