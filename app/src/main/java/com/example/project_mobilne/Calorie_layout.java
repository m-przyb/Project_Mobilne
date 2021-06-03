package com.example.project_mobilne;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Calorie_layout extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private RadioButton MaleBTN;
    private Spinner spinner;
    private RadioButton FemaleBTN;
    private String[] myList = new String[] { "Hello", "World", "Foo", "Bar" };
    private String[] myList2 = new String[] { "Hello New", "World Mew", "Foo New", "Bar New" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_layout);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        RadioButton MaleBTN = (RadioButton) findViewById(R.id.MaleButton);
        RadioButton FemaleBTN = (RadioButton) findViewById(R.id.FemaleButton);

        TextView result = (TextView) findViewById(R.id.dailyCalories);
        EditText EditWeight = (EditText) findViewById(R.id.editTextNumberWeight);

        MaleBTN.setOnCheckedChangeListener(this);
        FemaleBTN.setOnCheckedChangeListener(this);
        spinner.setAdapter(new ArrayAdapter<String>(Calorie_layout.this, android.R.layout.simple_spinner_item, myList));

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            if(buttonView == MaleBTN){
                spinner.setAdapter(new ArrayAdapter<String>(Calorie_layout.this, android.R.layout.simple_spinner_item, myList));
            }else if(buttonView == FemaleBTN ){
                spinner.setAdapter(new ArrayAdapter<String>(Calorie_layout.this, android.R.layout.simple_spinner_item, myList2));
            }
        }
    }
}
