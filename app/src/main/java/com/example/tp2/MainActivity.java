package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView appNameTxt;
    Button exo1Btn, exo2Btn, exo3Btn, exo4Btn, exo5Btn, exo6Btn, exo7Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appNameTxt = findViewById(R.id.appName);
        exo1Btn = findViewById(R.id.exo1_btn);
        exo2Btn = findViewById(R.id.exo2_btn);
        exo3Btn = findViewById(R.id.exo3_btn);
        exo4Btn = findViewById(R.id.exo4_btn);
        exo5Btn = findViewById(R.id.exo5_btn);
        exo6Btn = findViewById(R.id.exo6_btn);
        exo7Btn = findViewById(R.id.exo7_btn);

        // Exercice 1
        exo1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice1_activity.class);
                startActivity(i);
            }
        });

        // Exercice 2
        exo2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice2_activity.class);
                startActivity(i);
            }
        });

        // Exercice 3
        exo3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice3_activity.class);
                startActivity(i);
            }
        });

        // Exercice 4
        exo4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice4_activity.class);
                startActivity(i);
            }
        });

        // Exercice 5
        exo5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice5_activity.class);
                startActivity(i);
            }
        });

        // Exercice 6
        exo6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice6_activity.class);
                startActivity(i);
            }
        });

        // Exercice 7
        exo7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Exercice7_activity.class);
                startActivity(i);
            }
        });

    }
}