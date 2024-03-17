package com.example.tp2;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Exercice3_activity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);

        // Initialisation du SensorManager et du capteur de l'accéléromètre
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Enregistrement du SensorEventListener pour l'accéléromètre
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Désenregistrement du SensorEventListener lorsque l'activité est en pause
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Calcul de l'accélération totale
            double acceleration = Math.sqrt(x * x + y * y + z * z);

            // Choix de la couleur en fonction de l'accélération
            int backgroundColor;
            if (acceleration < 10) {
                backgroundColor = Color.GREEN; // Valeurs inférieures
            } else if (acceleration >= 10 && acceleration <= 20) {
                backgroundColor = Color.BLACK; // Valeurs moyennes
            } else {
                backgroundColor = Color.RED; // Valeurs supérieures
            }

            // Changement de la couleur de fond de l'activité
            getWindow().getDecorView().setBackgroundColor(backgroundColor);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
