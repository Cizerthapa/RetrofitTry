package com.cizer.tryretrofit.views.viewholder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cizer.tryretrofit.R;
import com.cizer.tryretrofit.RegisterResponse;
import com.cizer.tryretrofit.model.User;
import com.cizer.tryretrofit.utilities.RetroApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    EditText reg_name, reg_email, reg_password, reg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        reg_name = findViewById(R.id.reg_name);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_gender = findViewById(R.id.reg_gender);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void register(View view) {

        String name1 = reg_name.getText().toString();
        String email1 = reg_email.getText().toString();
        String pass1 = reg_password.getText().toString();
        String gender1 = reg_gender.getText().toString();

        User u = new User(name1, email1, pass1, gender1);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroApi retrofitapi = retrofit.create(RetroApi.class);

        retrofitapi.registerUser(u).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Extract response body and handle it accordingly
                    Toast.makeText(Register.this, "this registered", Toast.LENGTH_SHORT).show();
                    handleResponse(response.body());
                } else {
                    Toast.makeText(Register.this, "Failed to register", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(Register.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleResponse(Object responseBody) {
        if (responseBody instanceof RegisterResponse) {
            RegisterResponse registerResponse = (RegisterResponse) responseBody;
            // Extract status code
            int statusCode = registerResponse.getStatus();
            String s = String.valueOf(statusCode);

            Log.d("",s);
            // Determine registration success or failure based on status code
            if (statusCode == 1) {
                Toast.makeText(Register.this, "Registration successful: " + registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Register.this, "Registration failed: " + registerResponse.getError(), Toast.LENGTH_SHORT).show();
            }
        } else {
            //Toast.makeText(Register.this, "Unexpected response format", Toast.LENGTH_SHORT).show();
        }
    }
}
