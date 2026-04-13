package com.example.all_layout;

import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCenter = findViewById(R.id.btnCenter);

        btnCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Center Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}