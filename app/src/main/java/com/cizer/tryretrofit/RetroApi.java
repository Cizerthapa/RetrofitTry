package com.cizer.tryretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroApi {

    @POST("register.php")
    Call<Object> registerUser(@Body User user);

    @FormUrlEncoded
    @POST("registernew.php/register")
    Call<RegisterResponse> register(
            @Field("key_name") String name,
            @Field("key_email") String email,
            @Field("key_pass") String pass,
            @Field("key_gender") String gender
    );
    //void reg(@Field() String name, String email , String pass, String gender){}
}
