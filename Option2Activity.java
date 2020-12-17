package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Option2Activity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    private View view1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option2);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        view1=findViewById(R.id.view);
        textView=findViewById(R.id.textDist);

        if(sensor==null)
            finish();

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                textView.setText(sensorEvent.values[0]+"  Cm");

                if(sensorEvent.values[0]<sensor.getMaximumRange()){
                    view1.setBackgroundColor(Color.RED);

                }else{
                    view1.setBackgroundColor(Color.YELLOW);

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
    }
    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause(){
        stop();
        super.onPause();
    }

    @Override
    protected void onResume(){
        start();
        super.onResume();
    }
}