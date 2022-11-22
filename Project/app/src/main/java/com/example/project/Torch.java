package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Torch extends AppCompatActivity {
    Button b1,b2,b3;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        b1=(Button) findViewById(R.id.button22);
        b2=(Button) findViewById(R.id.button23);
        b3=(Button) findViewById(R.id.button24);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String cameraid=cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraid,true);
                }
                catch (CameraAccessException e)
                {

                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    String cameraid=cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraid,false);
                }
                catch(CameraAccessException e)
                {

                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Torch.this,Third.class);
                startActivity(i);
                finish();
            }
        });



    }
}