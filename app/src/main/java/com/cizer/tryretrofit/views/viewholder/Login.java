package com.cizer.tryretrofit.views.viewholder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cizer.tryretrofit.R;
import com.cizer.tryretrofit.utilities.ApiClient;

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find views by their IDs
        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        Button loginButton = findViewById(R.id.btn_login);
        TextView signInText = findViewById(R.id.signUpText);

        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        // Set OnClickListener on the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve text from EditText fields
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill in the details", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform login operation
                    ApiClient.loginUser(username,password,Login.this);
                }
            }
        });
    }
}
