package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP2 extends AppCompatActivity {
    EditText e1;
    Button b1;
    String phone;
    String otp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp2);
        phone=getIntent().getStringExtra("mobile").toString();
        e1=(EditText) findViewById(R.id.editText10);
        b1=(Button) findViewById(R.id.button30);
        firebaseAuth=FirebaseAuth.getInstance();

        genotp();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().isEmpty())
                {
                    Toast.makeText(OTP2.this, "please enter otp", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (e1.getText().toString().length()!=6)
                    {
                        Toast.makeText(OTP2.this, "length mismatch", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e1.getText().toString());
                        signInwithPhoneAuthCredential(credential);
                    }
                }
            }
        });
    }
        private void genotp()
        {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phone,
                    60,
                    TimeUnit.SECONDS,
                    this,
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            super.onCodeSent(s, forceResendingToken);
                            otp=s;
                        }

                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            signInwithPhoneAuthCredential(phoneAuthCredential);

                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Toast.makeText(OTP2.this, "Error occured", Toast.LENGTH_SHORT).show();

                        }
                    }

            );
        }
            private  void signInwithPhoneAuthCredential(PhoneAuthCredential credential)
            {
                firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(OTP2.this, "database updated", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(OTP2.this,OTP3.class);
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(OTP2.this, "Database not updated", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
}