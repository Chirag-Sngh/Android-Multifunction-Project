package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TiltAll extends AppCompatActivity implements SensorEventListener {
    WifiManager wm;
    BluetoothAdapter ba;
    MediaPlayer mp;
    CameraManager cm;
    Vibrator v1;
    SensorManager sm;
    Sensor s;
    Button b1,b2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilt_all);
        wm=(WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
        mp=MediaPlayer.create(this,R.raw.t);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        t1=(TextView)findViewById(R.id.textView3);
        b1=(Button)findViewById(R.id.button38);
        b2=(Button)findViewById(R.id.button39);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        String s5="Tilt it back ";
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TiltAll.this,Third.class);
                startActivity(i);
                finish();
            }
        });







    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        if (x1!=0)
        {
            mp.start();
            wm.setWifiEnabled(true);
            try {
                String cameraid=cm.getCameraIdList()[0];
                cm.setTorchMode(cameraid,true);

            }
            catch (CameraAccessException e)
            {

            }
                if (Build.VERSION.SDK_INT>26)
                {
                    v1.vibrate(5000);
                }
                else
                {
                    v1.vibrate(5000);
                }
                t1.setText("Tilt it back");


        }
        else
        {
            mp.pause();
            wm.setWifiEnabled(false);
            try {
                String cameraid=cm.getCameraIdList()[0];
                cm.setTorchMode(cameraid,false);
            }
            catch (CameraAccessException e)
            {

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}