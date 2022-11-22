package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class gmaillogin2 extends AppCompatActivity {
    TextView t1;
    ImageView i1;
    Button b1;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaillogin2);
        t1=(TextView) findViewById(R.id.textView);
        b1=(Button) findViewById(R.id.button37);
        i1=(ImageView) findViewById(R.id.imageView);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null)
        {
            Glide.with(gmaillogin2.this).load(firebaseUser.getPhotoUrl()).into(i1);
            t1.setText(firebaseUser.getDisplayName());
        }
        googleSignInClient= GoogleSignIn.getClient(gmaillogin2.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut();
                firebaseAuth.signOut();
                Intent j=new Intent(gmaillogin2.this,Third.class);
                startActivity(j);
                finish();
            }
        });
    }
}