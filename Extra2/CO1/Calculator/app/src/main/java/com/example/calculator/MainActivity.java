package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText val1,val2,val3;
    Button add,mul,div,sub;
    Double ip1,ip2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1=(EditText) findViewById(R.id.val1);
        val2=(EditText) findViewById(R.id.val2);
        val3=(EditText)findViewById(R.id.val3);
        add=(Button) findViewById(R.id.add);
        mul=(Button) findViewById(R.id.mul);
        div=(Button) findViewById(R.id.div);
        sub=(Button) findViewById(R.id.sub);

    }
    public void add(View v)
    {
        ip1=Double.parseDouble(String.valueOf(val1.getText()));
        ip2=Double.parseDouble(String.valueOf(val2.getText()));
        result=ip1+ip2;
        val3.setText(Double.toString(result));

    }

    public void mul(View v)
    {
        ip1=Double.parseDouble(String.valueOf(val1.getText()));
        ip2=Double.parseDouble(String.valueOf(val2.getText()));
        result=ip1*ip2;
        val3.setText(Double.toString(result));
    }
    public void sub(View v)
    {
        ip1=Double.parseDouble(String.valueOf(val1.getText()));
        ip2=Double.parseDouble(String.valueOf(val2.getText()));
        result=ip1-ip2;
        val3.setText(Double.toString(result));
    }
    public void div(View v)
    {
        ip1=Double.parseDouble(String.valueOf(val1.getText()));
        ip2=Double.parseDouble(String.valueOf(val2.getText()));
        result=ip1/ip2;
        val3.setText(Double.toString(result));
    }
}