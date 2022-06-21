package com.example.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    Retrofit retrofitService = new Retrofit.Builder().
            baseUrl("https://love-calculator.p.rapidapi.com").
            addConverterFactory(GsonConverterFactory.create()).
            build();

    public LoveAPI loveAPI = retrofitService.create(LoveAPI.class);

}

