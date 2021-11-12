package com.ramandeepkaur.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
// default supper class
public class MainActivity extends AppCompatActivity {
// declaring variables
    String oldNumber="";
    String op = "+";
//set boolen value true
    boolean isNewOp = true;
//creating variable
    EditText ed1;
// creating sub class and calling super class method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
    }
// checking buttons and displaying them on screen when user enter any data
    public void numberEvent(View view) {
        if (isNewOp)
            ed1.setText("");
        isNewOp = false;

        String number = ed1.getText().toString();
        switch (view.getId() ) {
            case R.id.b1:
                number += "1";
                break;
            case R.id.b2:
                number += "2";
                break;
            case R.id.b3:
                number += "3";
                break;
            case R.id.b4:
                number += "4";
                break;
            case R.id.b5:
                number += "5";
                break;
            case R.id.b6:
                number += "6";
                break;
            case R.id.b7:
                number += "7";
                break;
            case R.id.b8:
                number += "8";
                break;
            case R.id.b9:
                number += "9";
                break;
            case R.id.b0:
                number += "0";
                break;
            case R.id.decimal:
                number += ".";
                break;
            case R.id.addsub:
                number = "-"+number;
                break;
        }
        ed1.setText (number);

    }
// working on operator like when user want to operate any result it gives them answer
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        //using switch case statement
        switch (view.getId()) {
            case R.id.divide: op = "/"; break;
            case R.id.multi: op = "*"; break;
            case R.id.plus: op = "+"; break;
            case R.id.sub: op = "-"; break;
        }
    }
//creating method for equal button
    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
// printing results
        double result = 0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                break;

        }
        ed1.setText(result+"");
    }
// method for clear button
    public void cEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double num = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(num+"");
        isNewOp = true;
    }
}