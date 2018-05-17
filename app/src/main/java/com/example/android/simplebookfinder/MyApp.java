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
                .baseUrl("https://www.googleapis.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        sBookApi = retrofit.create(BookApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static BookApi getApi() {
        return sBookApi;
    }
}
