package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Exercice2_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SensorAdapter2 adapter;
    private List<String> unavailableSensorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice2);

        recyclerView = findViewById(R.id.recycler_view_exo2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        unavailableSensorsList = getUnavailableSensorsList();

        adapter = new SensorAdapter2(unavailableSensorsList);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getUnavailableSensorsList() {
        List<String> unavailableSensors = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            if (!isSensorAvailable(i)) {
                String sensorName = getSensorName(i);
                unavailableSensors.add(sensorName);
            }
        }
        return unavailableSensors;
    }

    private boolean isSensorAvailable(int sensorType) {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(sensorType);
        return sensorList != null && !sensorList.isEmpty();
    }

    private String getSensorName(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return "Accéléromètre";
            case Sensor.TYPE_GYROSCOPE:
                return "Gyroscope";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "Magnétomètre";
            case Sensor.TYPE_LIGHT:
                return "Capteur de lumière";
            case Sensor.TYPE_PROXIMITY:
                return "Capteur de proximité";
            case Sensor.TYPE_PRESSURE:
                return "Baromètre";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return "Capteur de température ambiante";
            case Sensor.TYPE_TEMPERATURE:
                return "Capteur de température du dispositif";
            case Sensor.TYPE_ROTATION_VECTOR:
                return "Capteur de rotation vectorielle";
            case Sensor.TYPE_GRAVITY:
                return "Capteur de gravité";
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return "Capteur linéaire d'accélération";
            case Sensor.TYPE_STEP_COUNTER:
                return "Capteur de pas";
            case Sensor.TYPE_STEP_DETECTOR:
                return "Capteur de pas détectés";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return "Capteur d'humidité relative";
            default:
                return "Type de capteur inconnu";
        }
    }
}
