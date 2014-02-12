package com.example.ldsconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

import android.widget.Toast;

public class MainActivity extends Activity {
    public float convcel;


    private EditText text;
    private EditText text1;
    private EditText text2;
    private EditText text3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (EditText)findViewById(R.id.editText1);
        text1= (EditText)findViewById(R.id.editText2);//kelvin
        text2= (EditText)findViewById(R.id.editText3);//celsius
        text3= (EditText)findViewById(R.id.editText4);//ferenheit

        text1.setKeyListener(null);
        text2.setKeyListener(null);
        text3.setKeyListener(null);

    }


    public void calculate (View view){
        RadioButton kelvin = (RadioButton) findViewById(R.id.radio2);
        RadioButton celsius = (RadioButton)findViewById(R.id.radio1);
        RadioButton farenheit = (RadioButton)findViewById(R.id.radio0);


        float valor = Float.parseFloat(text.getText().toString());

        if (farenheit.isChecked()){
            text1.setText(String.valueOf(ConvertirFaKelvin(valor)));
            text2.setText(String.valueOf(ConvertirFaCelsi(valor)));
            text3.setText(String.valueOf(valor));
            celsius.setChecked(false);
            kelvin.setChecked(false);


        }
        if (celsius.isChecked()){
                text3.setText(String.valueOf(ConvertirCelFarenheit(valor)));
                text1.setText(String.valueOf(ConvertirCelKelvin(valor)));
                text2.setText(String.valueOf(valor));
                farenheit.setChecked (false);
                kelvin.setChecked(false);


            }

            if (kelvin.isChecked()){
                text1.setText(String.valueOf(valor));
                text3.setText(String.valueOf(ConvertirKelFarenheit(valor)));
                text2.setText(String.valueOf(ConvertirkelCelsius(valor)));
                farenheit.setChecked (false);
                celsius.setChecked(false);


            }


    }


    // desde farenheit
    private float ConvertirFaCelsi (float  faren){
        return  ((faren -32)*5/9);

    }


    private double ConvertirFaKelvin(float far){
    return (((far-32)/1.800)+273.15);
    }

//Desde Celsius

    private float ConvertirCelFarenheit(float celsi){
        return ((celsi *9/5) +32);
    }
    private double ConvertirCelKelvin(float celsi){
        return (celsi + 273.15);
    }
   //desde Kelvin
    private double ConvertirKelFarenheit(float kelvin){
        return ((kelvin - 273.15)* 9)/5 + 32;
    }
    private double ConvertirkelCelsius(float kelvin){
        return kelvin - 273.15;
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }
}
