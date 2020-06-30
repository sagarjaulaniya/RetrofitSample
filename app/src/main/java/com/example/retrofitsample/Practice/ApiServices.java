package com.example.retrofitsample.Practice;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("posts")
    Call<List<Post>> getPost();

//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComment(@Path("id") int userId);

    @GET("/comments")
    Call<List<Comment>> getComment(@Query("postId") Integer[] postId,
                                   @Query("_sort") String sortBy,
                                   @Query("_desc") String descBy);

//    @GET("/comments")
//    Call<List<Comment>> getComment(@QueryMap Map<String,String> params);

    @POST("/posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("/posts")
    Call<Post> createPost(@Field("userId") int userId,
                          @Field("title") String title,
                          @Field("body") String text);

    @FormUrlEncoded
    @POST("/posts")
    Call<Post> createPost(@FieldMap Map<String, String> postMap);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
