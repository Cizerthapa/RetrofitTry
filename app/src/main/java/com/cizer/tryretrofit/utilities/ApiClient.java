package com.cizer.tryretrofit.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cizer.tryretrofit.model.LoginUser;
import com.cizer.tryretrofit.model.ProductLaptop;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://100.64.218.179/api/";
    private static final Retrofit retrofit;

    // Create the Retrofit instance
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetroApi createApiService() {
        return retrofit.create(RetroApi.class);
    }
    // Create ApiService instance
    public static void loginUser(String username, String password, Context context) {
        RetroApi apiService = createApiService();
        LoginUser user = new LoginUser(username,  password);
        // Get the ApiService instance

        // Call the loginUser method in ApiService and pass the user object
        apiService.loginUser(user).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User registration successful");
                    // Optionally, you can navigate to another activity upon successful registration
                    // startActivity(new Intent(context, MainActivity.class));
                } else {
                    // Display error message to the user
                    Toast.makeText(context, "Failed to login user. Please try again later.", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "Failed to  user. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Login failed due to network error or other issues
                Toast.makeText(context, "Failed to login. Please try again later.", Toast.LENGTH_SHORT).show();
                Log.e("LoginPage", "Login failed: " + t.getMessage());
            }
        });
    }
    public void getProducts(ApiCallback callback) {
        Call<List<ProductLaptop>> call = createApiService().getProducts();
        call.enqueue(new Callback<List<ProductLaptop>>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductLaptop>> call, @NonNull Response<List<ProductLaptop>> response) {
                if (response.isSuccessful()) {
                    ArrayList<ProductLaptop> products = new ArrayList<>(response.body());
                    callback.onSuccess(products);
                    Log.d("GET_PRODUCTS_SUCCESS", "Products received: " + products);

                } else {
                    callback.onFailure("Failed to get products. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<ProductLaptop>> call, Throwable t) {
                callback.onFailure("Failed to get products: " + t.getMessage());
            }
        });
    }
}
