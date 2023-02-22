package com.example.exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_IDENTITY = 1;
    private static final int REQUEST_CODE_ADDRESS = 2;

    private TextView nameTextView;
    private TextView firstNameTextView;
    private TextView phoneTextView;
    private TextView numberTextView;
    private TextView streetTextView;
    private TextView postalCodeTextView;
    private TextView cityTextView;

    private String name;
    private String firstName;
    private String phone;
    private String number;
    private String street;
    private String postalCode;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.editTextNom);
        firstNameTextView = findViewById(R.id.editTextPrenom);
        phoneTextView = findViewById(R.id.editTextTelephone);
        numberTextView = findViewById(R.id.editTextNumero);
        streetTextView = findViewById(R.id.editTextRue);
        postalCodeTextView = findViewById(R.id.editTextCodePostal);
        cityTextView = findViewById(R.id.editTextVille);

        Button identityButton = findViewById(R.id.buttonModifierIdentite);
        identityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IdentityActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("firstName", firstName);
                intent.putExtra("phone", phone);
                startActivityForResult(intent, REQUEST_CODE_IDENTITY);
            }
        });

        Button addressButton = findViewById(R.id.buttonModifierAdresse);
        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                intent.putExtra("number", number);
                intent.putExtra("street", street);
                intent.putExtra("postalCode", postalCode);
                intent.putExtra("city", city);
                startActivityForResult(intent, REQUEST_CODE_ADDRESS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_IDENTITY && resultCode == RESULT_OK) {
            name = data.getStringExtra("name");
            firstName = data.getStringExtra("firstName");
            phone = data.getStringExtra("phone");
            nameTextView.setText(name);
            firstNameTextView.setText(firstName);
            phoneTextView.setText(phone);
        }

        if (requestCode == REQUEST_CODE_ADDRESS && resultCode == RESULT_OK) {
            number = data.getStringExtra("number");
            street = data.getStringExtra("street");
            postalCode = data.getStringExtra("postalCode");
            city = data.getStringExtra("city");
            numberTextView.setText(number);
            streetTextView.setText(street);
            postalCodeTextView.setText(postalCode);
            cityTextView.setText(city);
        }
    }
}