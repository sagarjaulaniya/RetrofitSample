package com.example.retrofitsample.verificationProcess;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface VerifyApi {
    String Base_Url = "https://www.google.com/recaptcha/api/";
    Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @FormUrlEncoded
    @POST("/siteverify/")
    Call<String> getVerification(@FieldMap Map<String, String> params);
}
