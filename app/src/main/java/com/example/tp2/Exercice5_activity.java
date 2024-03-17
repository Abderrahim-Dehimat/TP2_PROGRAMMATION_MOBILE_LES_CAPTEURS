package com.example.tp2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Exercice5_activity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private CameraManager cameraManager;
    private Sensor accelerometer;
    private boolean isFlashOn = false;
    private long lastShakeTime;
    private static final int SHAKE_THRESHOLD = 800; // Seuil de secousse en millisecondes
    private String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);

        // Vérifiez si l'appareil prend en charge le flash
        PackageManager pm = getPackageManager();
        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // Si le flash n'est pas disponible, affichez un message d'erreur et quittez l'application
            Toast.makeText(this, "Flash non disponible sur cet appareil!", Toast.LENGTH_SHORT).show();
            finish();
        }

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer != null) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }

        // Initialiser le CameraManager pour contrôler le flash
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            if (cameraManager != null) {
                cameraId = cameraManager.getCameraIdList()[0];
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastShakeTime) > SHAKE_THRESHOLD) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Calculer l'accélération totale
            double acceleration = Math.sqrt(x * x + y * y + z * z);

            if (acceleration > 20) {
                toggleFlash();
                lastShakeTime = currentTime;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void toggleFlash() {
        try {
            if (isFlashOn) {
                // Éteindre le flash
                cameraManager.setTorchMode(cameraId, false);
                isFlashOn = false;
            } else {
                // Allumer le flash
                cameraManager.setTorchMode(cameraId, true);
                isFlashOn = true;
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
