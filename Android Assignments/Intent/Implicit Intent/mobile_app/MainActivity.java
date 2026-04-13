package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWeb, btnCall, btnMap, btnGallery, btnGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = findViewById(R.id.btnWeb);
        btnCall = findViewById(R.id.btnCall);
        btnMap = findViewById(R.id.btnMap);
        btnGallery = findViewById(R.id.btnGallery);
        btnGame = findViewById(R.id.button);  // Initialize Game button

        // 🌐 Open Web Browser
        btnWeb.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com"));
            startActivity(webIntent);
        });

        // 📞 Open Phone Dialer
        btnCall.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:9763314832"));
            startActivity(callIntent);
        });

        // 🗺 Open Map
        btnMap.setOnClickListener(v -> {
            Uri mapUri = Uri.parse("geo:0,0?q=Kolhapur");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            startActivity(mapIntent);
        });

        // 🖼 Open Gallery
        btnGallery.setOnClickListener(v -> {
            Intent galleryIntent = new Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(galleryIntent);
        });

        // 🎮 Open Play Store (Example)
        btnGame.setOnClickListener(v -> {
            Intent playIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store"));
            startActivity(playIntent);
        });
    }
}
