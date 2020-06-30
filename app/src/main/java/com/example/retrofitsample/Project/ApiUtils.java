package com.example.retrofitsample.Project;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiUtils {

    @FormUrlEncoded
    @POST
    Call<Response> login(@Field("email") String email, @Field("password") String password);
}
