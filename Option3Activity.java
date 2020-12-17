package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Option3Activity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private TextView textView;
    private Sensor tempSensor;
    private Boolean iaTemperatureSensorDisponible;
    private View  view;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);

        textView=findViewById(R.id.textTemp);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        view=findViewById(R.id.view);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null)
        {
            tempSensor=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            iaTemperatureSensorDisponible=true;

        }else{
            textView.setText("El sensor de temperatura no disponible");
            iaTemperatureSensorDisponible=false;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
       textView.setText(sensorEvent.values[0]+"  °C");

        if(sensorEvent.values[0]>37){
            view.setBackgroundColor(Color.RED);

        } else if(sensorEvent.values[0]>10 && sensorEvent.values[0]<37 ){
            view.setBackgroundColor(Color.GRAY);

        }else if(sensorEvent.values[0]<0 && sensorEvent.values[0]>-37){
            view.setBackgroundColor(Color.CYAN);
        }else{
            view.setBackgroundColor(Color.BLUE);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (iaTemperatureSensorDisponible) {
            sensorManager.registerListener(this, tempSensor, sensorManager.SENSOR_DELAY_NORMAL);

        }
    }
        @Override
        protected void onPause() {
            super.onPause();
            if (iaTemperatureSensorDisponible) {
                sensorManager.unregisterListener( this);
            }
        }

}