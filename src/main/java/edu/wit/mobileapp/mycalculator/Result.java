package edu.wit.mobileapp.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = this.getIntent().getExtras();
        int feet = bundle.getInt("ft");
        int inches = bundle.getInt("in");
        String gender = bundle.getString("gender");

        Log.v("myApp", "feet: " + feet + " inches: " + inches + " gender: " + gender);

        TextView dispGend = findViewById(R.id.dispGend);
        TextView dispHeight = findViewById(R.id.dispHeight);
        TextView dispWeight = findViewById(R.id.dispWeight);
        dispGend.setText(dispGend.getText() + " " + gender);
        dispHeight.setText(dispHeight.getText() + " " + feet + "'" + inches + "\"");
        double bodyWeight;
        if(gender.equalsIgnoreCase("Male"))
        {
            bodyWeight = 50 + 2.3 * ((feet * 12 + inches) - 60);
        }
        else
        {
            bodyWeight = 45.5 + 2.3 * ((feet * 12 + inches) - 60);
        }
        dispWeight.setText(dispWeight.getText() + " " + bodyWeight + " kg");
    }
}
