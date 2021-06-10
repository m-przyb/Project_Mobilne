package com.example.project_mobilne;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calorie_layout extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private RadioButton MaleBTN;
    private RadioButton FemaleBTN;
    private Spinner spinner2;
    private Spinner spinner;
    private TextView result;
    private float Multiplier;
    private float Multiplier2;
    private float Multiplier3;
    private String[] myList = new String[] { "14-18%", "19-28%", "29-38%", "Powyżej 38%" };
    private String[] myList2 = new String[] { "10-14%", "15-20%", "21-28%", "Powyżej 28%" };
    private String[] myList3 = new String[] { "Brak aktywności", "Mała aktywność", "Srednia aktywność", "Duza aktywność", "Bardzo duża aktywność" };
    private CompoundButton buttonView;
    private EditText Weight;
    private Button Calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_layout);


        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        MaleBTN = (RadioButton) findViewById(R.id.MaleButton);
        FemaleBTN = (RadioButton) findViewById(R.id.FemaleButton);
        Calculate = (Button) findViewById(R.id.buttonCalculate);

        result = (TextView) findViewById(R.id.dailyCalories);
        Weight = (EditText) findViewById(R.id.editTextNumberWeight);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sweight = Weight.getText().toString();
                float weigthValue = Float.parseFloat(Sweight);
                float daily = weigthValue * 24;
                float daily2 = daily * Multiplier * Multiplier2 * Multiplier3;
                int daily3 = (int) daily2;
                String Calories = Integer.toString(daily3);
                result.setText(Calories + " Kcal");

            }
        });


        spinner.setAdapter(new ArrayAdapter<>(Calorie_layout.this, android.R.layout.simple_spinner_item, myList3));
        MaleBTN.setOnCheckedChangeListener(this);
        FemaleBTN.setOnCheckedChangeListener(this);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(id == 0){
                    Multiplier3 = (float)1;
                }else if(id == 1){
                    Multiplier3 = (float)0.95;
                }else if(id == 2){
                    Multiplier3 = (float)0.90;
                }else if(id == 3){
                    Multiplier3 = (float)0.85;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0) {
                    Multiplier2 = (float) 1.3;
                } else if (id == 1) {
                    Multiplier2 = (float)1.55;
                } else if (id == 2) {
                    Multiplier2 = (float)1.65;
                } else if (id == 3) {
                    Multiplier2 = (float)1.80;
                } else if (id == 4) {
                    Multiplier2 = (float)2.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            if(buttonView == MaleBTN){
                spinner2.setAdapter(new ArrayAdapter<String>(Calorie_layout.this, android.R.layout.simple_spinner_item, myList2));
                Multiplier = (float) 1.0;

            }else {
                spinner2.setAdapter(new ArrayAdapter<String>(Calorie_layout.this, android.R.layout.simple_spinner_item, myList));
                Multiplier = (float) 0.9;
            }
        }
    }


}
