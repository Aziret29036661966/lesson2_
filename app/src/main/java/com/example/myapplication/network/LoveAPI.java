package com.example.myapplication.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoveAPI {
    @GET("getPercentage")
    Call<LoveModel> loveCall(@Query("fname") String firstName,
                             @Query("sname") String secondName,
                             @Header("X-RapidAPI-Key") String key,
                             @Header("X-RapidAPI-Host")String host);
}
