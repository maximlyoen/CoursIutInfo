package com.example.exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {
    // Les champs pour l'adresse
    private EditText numeroEditText, rueEditText, codePostalEditText, villeEditText;
    private String numero, rue, codePostal, ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editaddressactivity);

        // Récupération des champs pour l'adresse
        numeroEditText = findViewById(R.id.editTextNumber);
        rueEditText = findViewById(R.id.editTextStreet);
        codePostalEditText = findViewById(R.id.editTextPostalCode);
        villeEditText = findViewById(R.id.editTextCity);

        // Récupération des données d'adresse de l'Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numero = extras.getString("numero");
            rue = extras.getString("rue");
            codePostal = extras.getString("codePostal");
            ville = extras.getString("ville");

            // Affichage des données d'adresse dans les champs
            numeroEditText.setText(numero);
            rueEditText.setText(rue);
            codePostalEditText.setText(codePostal);
            villeEditText.setText(ville);
        }

        // Gestion du bouton de validation
        Button validerButton = findViewById(R.id.buttonSave);
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération des valeurs modifiées dans les champs
                numero = numeroEditText.getText().toString();
                rue = rueEditText.getText().toString();
                codePostal = codePostalEditText.getText().toString();
                ville = villeEditText.getText().toString();

                // Envoi des données modifiées à l'activité principale
                Intent resultIntent = new Intent();
                resultIntent.putExtra("numero", numero);
                resultIntent.putExtra("rue", rue);
                resultIntent.putExtra("codePostal", codePostal);
                resultIntent.putExtra("ville", ville);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        // Gestion du bouton d'annulation
        Button annulerButton = findViewById(R.id.buttonCancel);
        annulerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
