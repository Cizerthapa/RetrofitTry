package com.cizer.tryretrofit.views.viewholder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                // Perform login operation
                //LoginUser ls = new LoginUser(username, password);
                //loginUser(ls);
                ApiClient.loginUser(username,password,Login.this);
            }
        });
    }

//    private void loginUser(LoginUser ls) {
//        // Create Retrofit instance
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        // Create API service
//        RetroApi retrofitapi = retrofit.create(RetroApi.class);
//
//        // Call the loginUser method in ApiService and pass the user object
//        retrofitapi.loginUser(ls).enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    // Extract response body and handle it accordingly
//                    Toast.makeText(Login.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(Login.this, "Failed to register: " + response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Toast.makeText(Login.this, "Failed to register: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
