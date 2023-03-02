package com.example.exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IdentityActivity extends AppCompatActivity {

    private EditText mEditFirstName;
    private EditText mEditLastName;
    private EditText mEditPhoneNumber;
    private Button mButtonSave;
    private Button mButtonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editidentityactivity);

        // Get references to UI elements
        mEditFirstName = findViewById(R.id.edit_first_name);
        mEditLastName = findViewById(R.id.edit_last_name);
        mEditPhoneNumber = findViewById(R.id.edit_phone);
        mButtonSave = findViewById(R.id.button_save);
        mButtonCancel = findViewById(R.id.button_cancel);

        // Get the current identity data from the main activity
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String phoneNumber = intent.getStringExtra("phoneNumber");

        // Display the current identity data in the edit text fields
        mEditFirstName.setText(firstName);
        mEditLastName.setText(lastName);
        mEditPhoneNumber.setText(phoneNumber);

        // Set up click listeners for the buttons
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveIdentity();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelEdit();
            }
        });
    }

    private void saveIdentity() {
        // Get the updated identity data from the edit text fields
        String firstName = mEditFirstName.getText().toString();
        String lastName = mEditLastName.getText().toString();
        String phoneNumber = mEditPhoneNumber.getText().toString();

        // Create a new intent to pass the updated identity data back to the main activity
        Intent intent = new Intent();
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);
        intent.putExtra("phoneNumber", phoneNumber);

        // Set the result of the activity to indicate that the identity data was updated successfully
        setResult(Activity.RESULT_OK, intent);

        // Finish the activity
        finish();
    }

    private void cancelEdit() {
        // Set the result of the activity to indicate that the identity data was not updated
        setResult(Activity.RESULT_CANCELED);

        // Finish the activity
        finish();
    }
}
