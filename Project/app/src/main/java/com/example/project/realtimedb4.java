package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class realtimedb4 extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtimedb4);
        e1=(EditText) findViewById(R.id.editText13);
        e2=(EditText) findViewById(R.id.editText14);
        e3=(EditText) findViewById(R.id.editText15);
        b1=(Button) findViewById(R.id.button36);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference=firebaseDatabase.getReference("Users");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();

                if(s3.length()!=10)
                {
                    Toast.makeText(realtimedb4.this, "Invalid number", Toast.LENGTH_SHORT).show();
                }

               else
                {
                    Users users=new Users(s1,s2,s3);
                    databaseReference.child(s3).setValue(users);
                    Toast.makeText(realtimedb4.this, "Database Updated", Toast.LENGTH_SHORT).show();
                }

                Intent j=new Intent(realtimedb4.this,Third.class);
                startActivity(j);
                finish();

            }
        });
    }
}