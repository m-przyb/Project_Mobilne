package com.example.project_mobilne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Fat_percentage extends AppCompatActivity {

    private EditText BMI;
    private EditText AGE;
    private RadioButton Women;
    private RadioButton Men;
    private float temp;
    private Button calculate;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_percentage);


        BMI = (EditText) findViewById(R.id.editTextNumberBMI);
        AGE = (EditText) findViewById(R.id.editTextNumberAge);
        Women = (RadioButton) findViewById(R.id.radioButtonWoman);
        Men = (RadioButton) findViewById(R.id.radioButtonMen);
        calculate = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.textViewResult);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float float_result = calculate();
                String S_result = Float.toString(float_result);
                DecimalFormat df = new DecimalFormat("0.00");
                result.setText(df.format(float_result) +"%");

                

            }
        });
        Men.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(buttonView == Women){
                        temp = (float) 5.4;
                    }else{
                        temp = (float) 16.2;
                    }
                }
            }
        });

    }
    public float calculate(){


        String S_bmi = BMI.getText().toString();
        String S_age = AGE.getText().toString();

        float bmi = Float.parseFloat(S_bmi);
        int age = Integer.parseInt(S_age);

        float value = (float) (bmi * 1.2 + 0.23*age - temp);

        return value;
    }
}