package com.example.englishcaard;

import android.app.Application;

import com.example.englishcaard.network.PixabayApi;
import com.example.englishcaard.network.RetrofitClient;


public class App extends Application {
   public static RetrofitClient retrofitClient;
    PixabayApi api;
    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.providePixabayApi();

    }
}
