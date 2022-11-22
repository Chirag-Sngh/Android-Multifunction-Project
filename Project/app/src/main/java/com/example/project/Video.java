package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    MediaController m1;
    Uri uri;
    Button b1,b2;
    VideoView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        b1=(Button) findViewById(R.id.button27);
        b2=(Button) findViewById(R.id.button28);
        v1=(VideoView) findViewById(R.id.videoView);
        m1=new MediaController(this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Video.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(j,34);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==34)
        {
            uri=data.getData();
            v1.setVideoURI(uri);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.start();
        }
        else
        {
            Toast.makeText(this, "Camera not working", Toast.LENGTH_SHORT).show();
        }
    }
}