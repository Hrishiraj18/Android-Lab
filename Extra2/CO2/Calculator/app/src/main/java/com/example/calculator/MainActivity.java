package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Boolean op=true;
    String old="";
    String oper="+";
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=(EditText) findViewById(R.id.number);
    }

    public  void NumberEvent(View v)
    {
        if(op)
        {
            number.setText("");
        }
        op=false;
        String num=number.getText().toString();
        int vid= v.getId();

        if(vid==R.id.b1){
            num+="1";
        }
        else if(vid==R.id.b2){
            num+="2";
        }
        else if(vid==R.id.b3){
            num+="3";
        }
        else if(vid==R.id.b4){
            num+="4";
        }
        else if(vid==R.id.b5){
            num+="5";
        }
        else if(vid==R.id.b6){
            num+="6";
        }
        else if(vid==R.id.b7){
            num+="7";
        }
        else if(vid==R.id.b8){
            num+="8";
        }
        else if(vid==R.id.b9){
            num+="9";
        }
        else if(vid==R.id.b0){
            num+="0";
        }
        else if(vid==R.id.clr){
            num+="";
        }
        number.setText(num);
    }

    public  void OperatorEvent(View v)
    {
    op=true;
    old=number.getText().toString();

    if(v.getId()==R.id.add)
    {
        oper="+";
    }
    if(v.getId()==R.id.sub)
    {
        oper="-";
    }
    if(v.getId()==R.id.mul)
    {
        oper="*";
    }
    if(v.getId()==R.id.div)
    {
        oper="/";
    }
    }

    public void EqualEvent(View v)
    {
        String newno=number.getText().toString();
        Double res=0.0;

        switch (oper)
        {
            case "+":
                res=Double.parseDouble(old)+Double.parseDouble(newno);

                break;
            case "-":
                res=Double.parseDouble(old)-Double.parseDouble(newno);
                break;
            case "*":
                res=Double.parseDouble(old)*Double.parseDouble(newno);
                break;
            case "/":
                res=Double.parseDouble(old)/Double.parseDouble(newno);
                break;
        }
        number.setText(Double.toString(res));
    }
}