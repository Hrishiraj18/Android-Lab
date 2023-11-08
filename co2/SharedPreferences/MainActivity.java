package com.example.sharedpreference;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nameEditText, passwordEditText, phoneEditText, emailEditText, dobEditText, addressEditText;
    private RadioGroup radioGroup;
    private Button submitButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);

        nameEditText = findViewById(R.id.name);
        passwordEditText = findViewById(R.id.Password);
        phoneEditText = findViewById(R.id.Phone);
        emailEditText = findViewById(R.id.Email);
        dobEditText = findViewById(R.id.dob);
        addressEditText = findViewById(R.id.address);
        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.button);

        // Load saved data from SharedPreferences
        loadSavedData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                // Get the text from the EditText fields
                String name = nameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String dob = dobEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone) ||
                        TextUtils.isEmpty(email) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(address) ||
                        selectedRadioButtonId == -1) {
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    // Form is valid, save data to SharedPreferences
                    saveData(name, password, phone, email, dob, address, selectedRadioButton.getText().toString());
                    Toast.makeText(MainActivity.this, "Form Valid. Data saved!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveData(String name, String password, String phone, String email, String dob, String address, String gender) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("password", password);
        editor.putString("phone", phone);
        editor.putString("email", email);
        editor.putString("dob", dob);
        editor.putString("address", address);
        editor.putString("gender", gender);
        editor.apply();
    }

    private void loadSavedData() {
        String savedName = sharedPreferences.getString("name", "");
        String savedPassword = sharedPreferences.getString("password", "");
        String savedPhone = sharedPreferences.getString("phone", "");
        String savedEmail = sharedPreferences.getString("email", "");
        String savedDob = sharedPreferences.getString("dob", "");
        String savedAddress = sharedPreferences.getString("address", "");
        String savedGender = sharedPreferences.getString("gender", "");

        nameEditText.setText(savedName);
        passwordEditText.setText(savedPassword);
        phoneEditText.setText(savedPhone);
        emailEditText.setText(savedEmail);
        dobEditText.setText(savedDob);
        addressEditText.setText(savedAddress);

        // Select the saved gender in the RadioGroup
        if (!savedGender.isEmpty()) {
            RadioButton genderRadioButton = (RadioButton) radioGroup.findViewWithTag(savedGender);
            genderRadioButton.setChecked(true);
        }
    }
}
