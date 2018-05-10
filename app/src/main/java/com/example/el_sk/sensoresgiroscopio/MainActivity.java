package com.example.el_sk.sensoresgiroscopio;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView salida;
    Sensor sensor;
    SensorManager sensorManager;
    String cadena ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salida = findViewById(R.id.txtsalida);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                salida.setText("X "+event.values[0]+"\n"+"Y "+event.values[1]+"\n"+"Z "+event.values[2]);
                if (event.values[2]>0.5f){
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }else if (event.values[2]<-0.5f){
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);

                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);




    }

}
