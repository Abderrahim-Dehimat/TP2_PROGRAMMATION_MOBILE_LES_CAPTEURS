package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Exercice1_activity extends AppCompatActivity {

    // Declaring the views
    TextView exo1Txt;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice1);

        exo1Txt = findViewById(R.id.exo1_txt);
        recyclerView = findViewById(R.id.recycler_view);

        // appeller la fonction qui retourne la liste des capteurs disponibles
        List<Sensor> sensorList = getSensorList();
        SensorAdapter adapter = new SensorAdapter(sensorList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    // une méthode pour récupérer la liste des capteurs disponibles
    private List<Sensor> getSensorList() {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        return sensorManager.getSensorList(Sensor.TYPE_ALL);
    }

}