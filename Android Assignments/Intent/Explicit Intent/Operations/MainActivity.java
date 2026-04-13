package com.example.explicitintentgui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button addBtn, subBtn, mulBtn, divBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultText = findViewById(R.id.resultText);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        addBtn.setOnClickListener(v -> calculate("add"));
        subBtn.setOnClickListener(v -> calculate("sub"));
        mulBtn.setOnClickListener(v -> calculate("mul"));
        divBtn.setOnClickListener(v -> calculate("div"));
    }

    private void calculate(String operation) {

        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        double result = 0;

        switch (operation) {
            case "add":
                result = n1 + n2;
                break;
            case "sub":
                result = n1 - n2;
                break;
            case "mul":
                result = n1 * n2;
                break;
            case "div":
                if (n2 != 0)
                    result = n1 / n2;
                else {
                    resultText.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        resultText.setText("Result: " + result);
    }
}