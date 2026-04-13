package com.example.rn79;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    String name, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvName = findViewById(R.id.tvName);
        ImageView imgCall = findViewById(R.id.imgCall);
        ImageView imgMsg = findViewById(R.id.imgMsg);
        ImageView imgWhatsapp = findViewById(R.id.imgWhatsapp);

        name = getIntent().getStringExtra("name");
        number = getIntent().getStringExtra("number");

        tvName.setText(name + "\n" + number);

        imgCall.setOnClickListener(v -> {

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + number));
            startActivity(callIntent);

        });


        imgMsg.setOnClickListener(v -> {

            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:" + number));
            smsIntent.putExtra("sms_body", "Hello");
            startActivity(smsIntent);

        });


        imgWhatsapp.setOnClickListener(v -> {

            try {

                String num = number.replace("+", "").replace(" ", "");

                Intent waIntent = new Intent(Intent.ACTION_VIEW);
                waIntent.setData(Uri.parse("https://wa.me/" + num));
                startActivity(waIntent);

            } catch (Exception e) {

                Toast.makeText(this,
                        "WhatsApp not installed",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}