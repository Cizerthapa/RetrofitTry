package com.cizer.tryretrofit.utilities;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cizer.tryretrofit.Homefrag;
import com.cizer.tryretrofit.MainActivity;
import com.cizer.tryretrofit.RecyclerV;
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
    private static final String BASE_URL = "http://10.0.2.2/api/";
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
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "User Login successfully", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User Login successful");
                    // Optionally, you can navigate to another activity upon successful registration

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
                    Log.d("GETTING_PRODUCTS_SUCCESS", "Products received: " + products);

                } else {
                    callback.onFailure("Failed_getting_products. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<ProductLaptop>> call, Throwable t) {
                callback.onFailure("Failed to get products: " + t.getMessage());
            }
        });
    }
}
