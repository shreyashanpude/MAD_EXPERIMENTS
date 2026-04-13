package com.example.ratingbar;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener((bar, rating, fromUser) -> {
            Toast.makeText(MainActivity.this,
                    "Rating: " + rating,
                    Toast.LENGTH_SHORT).show();
        });
    }
}