package com.example.project_mobilne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBmi = (Button) findViewById(R.id.button_bmi);
        buttonBmi.setOnClickListener(view -> {
            Intent intent = new Intent(this , activity_bmi.class);
            startActivity(intent);

        });
        Button buttonCalorie = (Button) findViewById(R.id.calorie_button);
        buttonCalorie.setOnClickListener(view -> {
            Intent intent = new Intent(this , Calorie_layout.class);
            startActivity(intent);
    });
        Button buttonFat= (Button) findViewById(R.id.fat_button);
        buttonFat.setOnClickListener(view -> {
            Intent intent = new Intent(this , Fat_percentage.class);
            startActivity(intent);
        });
    }
}