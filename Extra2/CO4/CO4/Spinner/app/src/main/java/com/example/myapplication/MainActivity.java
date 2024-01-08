package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String cars[]={"Audi","Bmw","Porsche","Benz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cars);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selected=adapterView.getItemAtPosition(i).toString();
        if(selected=="Porsche")
        {
            Toast.makeText(this, "Porsche", Toast.LENGTH_SHORT).show();
        }
        if(selected=="Audi")
        {
            Toast.makeText(this, "Audi", Toast.LENGTH_SHORT).show();
        }
        if(selected=="Bmw")
        {
            Toast.makeText(this, "Bmw", Toast.LENGTH_SHORT).show();
        } if(selected=="Benz")
        {
            Toast.makeText(this, "Benz", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}