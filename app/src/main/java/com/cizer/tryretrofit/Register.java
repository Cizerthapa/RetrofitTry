package com.cizer.tryretrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    EditText reg_name, reg_email,reg_password, reg_gender;
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
    public void register(View view){

        String name1 =reg_name.getText().toString();
        String email1 =reg_email.getText().toString();
        String pass1 =reg_password.getText().toString();
        String gender1 =reg_gender.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.101.7/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroApi retrofitapi = retrofit.create(RetroApi.class);

        Call<RegisterResponse> call = retrofitapi.register(name1, email1, pass1, gender1);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse reg_response = response.body();
                String errorcode = reg_response.getErrorcode();
                String message = reg_response.getMessage();

                Toast.makeText(Register.this, "Error Code: " + errorcode + "\nMessage: " + message, Toast.LENGTH_SHORT).show();
                String toastMessage = "Name: " + name1 + "\nEmail: " + email1 + "\nPassword: " + pass1 + "\nGender: " + gender1;
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(Register.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                String toastMessage = "Name: " + name1 + "\nEmail: " + email1 + "\nPassword: " + pass1 + "\nGender: " + gender1;
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}