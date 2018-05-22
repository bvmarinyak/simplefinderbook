package com.example.android.simplebookfinder;

/**
 * Created by bvmarinyak on 17.05.18.
 */

import android.app.Application;

import com.example.android.simplebookfinder.api.BookApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    private static BookApi sBookApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/") 
                .addConverterFactory(GsonConverterFactory.create()) 
                .build();
        sBookApi = retrofit.create(BookApi.class); 
    }

    public static BookApi getApi() {
        return sBookApi;
    }
}
