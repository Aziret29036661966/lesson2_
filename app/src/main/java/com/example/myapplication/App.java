package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.network.LoveAPI;
import com.example.myapplication.network.RetrofitService;

public class App extends Application {
    public static LoveAPI loveAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitService retrofitService = new RetrofitService();
        loveAPI = retrofitService.loveAPI;
    }
}
