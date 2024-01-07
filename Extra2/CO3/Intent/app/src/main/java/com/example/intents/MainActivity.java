package com.example.intents;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText name, phone, email;
    Button button;
    RadioGroup gender;
    CheckBox terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.button);
        gender = (RadioGroup) findViewById(R.id.gender);
        terms = (CheckBox) findViewById(R.id.check);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(FormValidator.validateform(name,phone,email,gender,terms))
                {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login unsuccessful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name.getText().toString().trim());
        editor.putString("phone",phone.getText().toString().trim());
        editor.putString("email",email.getText().toString().trim());
        editor.putInt("gender",gender.getCheckedRadioButtonId());
        editor.putBoolean("terms",terms.isChecked());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh=getSharedPreferences("pref",MODE_PRIVATE);
        name.setText(sh.getString("name",""));
        phone.setText(sh.getString("phone",""));
        email.setText(sh.getString("email",""));
        gender.check(sh.getInt("gender",-1));
        terms.setChecked(sh.getBoolean("terms",false));
    }

    public static class FormValidator {
        public static boolean validateform(EditText name, EditText phone, EditText email, RadioGroup gender, CheckBox terms) {

            boolean flag = true;
            String name_passed = name.getText().toString().trim();
            if (TextUtils.isEmpty(name_passed)) {
                name.setError("Please enter your name");
                flag = false;
            }
            String phone_passed = phone.getText().toString().trim();
            if(TextUtils.isEmpty(phone_passed))
            {
                phone.setError("Please enter a phone number");
                flag = false;


            } else if (!Patterns.PHONE.matcher(phone_passed).matches()) {
                phone.setError("Please enter a valid phone number");
                flag = false;

            }
            String email_passed=email.getText().toString().trim();
            if(TextUtils.isEmpty(email_passed))
            {
                email.setError("Please enter an email address");
                flag = false;

            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email_passed).matches())
            {
                email.setError("Please enter a valid email address");
                flag = false;

            }
            int Selectedindex=gender.getCheckedRadioButtonId();
            if(Selectedindex==-1)
            {
                flag=false;
            }
            if(!terms.isChecked())
            {
                terms.setError("Please mark the checkbox");
                flag=false;
            }
            return flag;
        }
    }

}
