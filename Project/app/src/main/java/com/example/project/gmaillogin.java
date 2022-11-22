package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class gmaillogin extends AppCompatActivity {
    SignInButton signInButton;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaillogin);
        signInButton=(SignInButton) findViewById(R.id.signin);
        firebaseAuth=FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("337680379152-9neqalmgn65nflp2h2uqm6oncvqdatpa.apps.googleusercontent.com").requestEmail().build();
        googleSignInClient=GoogleSignIn.getClient(gmaillogin.this,googleSignInOptions);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=googleSignInClient.getSignInIntent();
                startActivityForResult(intent,99);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99)
        {
            Task<GoogleSignInAccount>googleSignInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount googleSignInAccount=googleSignInAccountTask.getResult();
            AuthCredential authCredential= GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
            firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(gmaillogin.this, "Database Updated", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(gmaillogin.this,gmaillogin2.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();

                    }
                    else
                    {
                        Toast.makeText(gmaillogin.this, "Database not updated", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}