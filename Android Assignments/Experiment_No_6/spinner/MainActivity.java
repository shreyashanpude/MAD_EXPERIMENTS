package com.example.spinner; // change if needed

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Spinner spinnerCity;
    Button btnSubmit;
    TextView txtResult;

    String selectedCity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        spinnerCity = findViewById(R.id.spinnerCity);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        // Spinner data
        String[] cities = {"Select City", "Pune", "Mumbai", "Delhi", "Bangalore"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                cities
        );

        spinnerCity.setAdapter(adapter);

        // Spinner event
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Button click
        btnSubmit.setOnClickListener(v -> {

            String name = editName.getText().toString();

            txtResult.setText(
                    "Name: " + name +
                            "\nCity: " + selectedCity
            );
        });
    }
}