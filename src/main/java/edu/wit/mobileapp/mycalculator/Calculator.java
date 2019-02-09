package edu.wit.mobileapp.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateBtn = findViewById(R.id.calculate);
        calculateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("myApp", "Calculate Button Clicked");
                //Feet
                EditText feet = findViewById(R.id.feetNum);
                //Inches
                EditText inches = findViewById(R.id.inchesNum);
                //Male or Female
                RadioGroup morf = findViewById(R.id.radioGender);
                int radioButtonID = morf.getCheckedRadioButtonId();
                RadioButton chosen =  morf.findViewById(radioButtonID);
                String selectedGender = (String) chosen.getText();

                Intent intent = new Intent();
                intent.setClass(Calculator.this, Result.class);

                Bundle bundle = new Bundle();
                bundle.putInt("ft", Integer.parseInt(feet.getText().toString()));
                bundle.putInt("in", Integer.parseInt(inches.getText().toString()));
                bundle.putString("gender", selectedGender);


                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
