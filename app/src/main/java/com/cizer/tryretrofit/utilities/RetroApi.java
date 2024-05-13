package com.cizer.tryretrofit.utilities;

import com.cizer.tryretrofit.RegisterResponse;
import com.cizer.tryretrofit.model.ContactInfo;
import com.cizer.tryretrofit.model.LoginUser;
import com.cizer.tryretrofit.model.ProductLaptop;
import com.cizer.tryretrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroApi {
    @POST("register.php")
    Call<Object> registerUser(@Body User user);

    @POST("login.php")
    Call<Object> loginUser(@Body LoginUser user);

    @GET("product.php")
    Call<List<ProductLaptop>> getProducts();

    @POST("contactus.php")
    Call<Object> sendMessage(@Body ContactInfo contactInfo);
}
