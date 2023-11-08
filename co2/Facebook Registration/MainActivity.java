package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.name);
    }
    public void Onclick(View view)
    {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        String str=name.getText().toString();
        intent.putExtra("username",str);
        startActivity(intent);
    }
}