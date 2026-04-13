package com.example.toggles;  // change if needed

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    RadioGroup radioGroup;
    CheckBox checkTerms;
    ToggleButton toggleBtn;
    Button btnSubmit;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        radioGroup = findViewById(R.id.radioGroup);
        checkTerms = findViewById(R.id.checkTerms);
        toggleBtn = findViewById(R.id.toggleBtn);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        btnSubmit.setOnClickListener(v -> {

            String name = editName.getText().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            String gender = "Not selected";

            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                gender = rb.getText().toString();
            }

            String terms = checkTerms.isChecked() ? "Accepted" : "Not Accepted";
            String toggle = toggleBtn.isChecked() ? "ON" : "OFF";

            txtResult.setText(
                    "Name: " + name +
                            "\nGender: " + gender +
                            "\nTerms: " + terms +
                            "\nToggle: " + toggle
            );
        });
    }
}