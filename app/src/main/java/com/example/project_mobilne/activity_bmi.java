package com.example.project_mobilne;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class activity_bmi extends AppCompatActivity {
    EditText weight, height;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Button btn = (Button) findViewById(R.id.button_check);

        height = findViewById(R.id.editTextNumberDecimal2);
        weight = findViewById(R.id.editTextNumberDecimal);
        result = findViewById(R.id.textView);


        btn.setOnClickListener(this::calculate);
    }

    public void calculate(View view){
        DecimalFormat df = new DecimalFormat("0.00");
        String Sweight = weight.getText().toString();
        String Sheight = height.getText().toString();
        if(Sheight != null && !"".equals(Sheight) && (Sweight != null && !"".equals(Sweight))){


            float Valueweight = Float.parseFloat(Sweight);
            float Valueheight = Float.parseFloat(Sheight) / 100;

            if(Valueheight <= 0 || Valueweight <=0) {
                Toast.makeText(getApplicationContext(), "Wprowadź prawidłowe dane", Toast.LENGTH_SHORT).show();
            }else {
                float BMI = Valueweight / (Valueheight * Valueheight);

                String bmiResult = bmiResult(BMI);
                String ResultText = "BMI: \n" + df.format(BMI) + "\n" + bmiResult;
                result.setText(ResultText);
            }
        }else Toast.makeText(getApplicationContext(), "Wprowadź dane", Toast.LENGTH_SHORT).show();
    }
     public String bmiResult(float bmi)
     {
         if(bmi<16)
         {
             return "Wygłodzenie";
         }else if(bmi >= 16 && bmi<17)
         {
             return "Wychudzenie";
         }else if(bmi >= 17 && bmi<18.49)
         {
             return "Niedowaga";
         }else if(bmi >= 18.50 && bmi<24.99)
         {
             return "Waga prawidłowa";
         }else if(bmi >= 25 && bmi<29.99)
         {
             return "Nadwaga";
         }else if(bmi >= 30 && bmi<34.99)
         {
             return "Otyłość pierwszego stopnia";
         }
         else if(bmi >= 35 && bmi<39.99)
         {
             return "Otyłość drugiego stopnia";
         }
         else return "Otyłość skrajna";
     }
}