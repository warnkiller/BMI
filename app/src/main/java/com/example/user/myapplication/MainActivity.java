package com.example.user.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private ImageView imageViewResult;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight=(EditText)findViewById(R.id.weightText);
        editTextHeight=(EditText)findViewById(R.id.heightText);
        imageViewResult=(ImageView)findViewById(R.id.imageResult);
        textViewResult=(TextView) findViewById(R.id.resultText);

    }
    public void calculateBMI(View view){
        double weight, height, result;
        weight=Double.parseDouble(editTextWeight.getText().toString());
        height=Double.parseDouble(editTextHeight.getText().toString());

        result=weight/(height*height);
        if(result<18.5&&result>0){
            imageViewResult.setImageResource(R.drawable.under);
        }
        if(result>=18.5&&result<25){
            imageViewResult.setImageResource(R.drawable.normal);
        }
        if(result>=25){
            imageViewResult.setImageResource(R.drawable.over);

        }
        textViewResult.setText(""+result);
    }
    public void resetField(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
