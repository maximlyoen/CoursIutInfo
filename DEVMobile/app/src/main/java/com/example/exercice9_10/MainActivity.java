package com.example.exercice9_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone;
    private EditText editTextUrl;
    private EditText editTextLatitude;
    private EditText editTextLongitude;
    private Button buttonSms;
    private Button buttonMms;
    private Button buttonAppel;
    private Button buttonWeb;
    private Button buttonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des vues depuis leur ID
        editTextPhone = findViewById(R.id.edit_text_phone);
        editTextUrl = findViewById(R.id.edit_text_url);
        editTextLatitude = findViewById(R.id.edit_text_latitude);
        editTextLongitude = findViewById(R.id.edit_text_longitude);
        buttonSms = findViewById(R.id.button_sms);
        buttonMms = findViewById(R.id.button_mms);
        buttonAppel = findViewById(R.id.button_appel);
        buttonWeb = findViewById(R.id.button_web);
        buttonMap = findViewById(R.id.button_map);

        // Définition des listeners pour chaque bouton
        buttonSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editTextPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("sms:" + phone));
                startActivity(intent);
            }
        });

        buttonMms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editTextPhone.getText().toString();
                String message = "Message de test";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra("address", phone);
                intent.putExtra("sms_body", message);
                intent.setType("image/*");
                startActivity(intent);
            }
        });

        buttonAppel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editTextPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });

        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextUrl.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latitude = editTextLatitude.getText().toString();
                String longitude = editTextLongitude.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:" + latitude + "," + longitude));
                startActivity(intent);
            }
        });
    }
}

