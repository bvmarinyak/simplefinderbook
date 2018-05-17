package com.example.android.simplebookfinder.api;

import com.example.android.simplebookfinder.BookModel.BookModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bvmarinyak on 17.05.18.
 */

public interface BookApi {
    @GET("books/v1/volumes/")
    Call<BookModel> getData(@Query("q") String parameter, @Query("key") String apiKey);
}
