package com.example.administrator.retrofit2.network;

import com.example.administrator.retrofit2.data.ArrayBook;
import com.example.administrator.retrofit2.data.Book;
import com.example.administrator.retrofit2.data.RetrofitResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018-01-29.
 */

public interface NetworkService {

    @GET("json")
    Call<RetrofitResult> getRetrofitResult();

    @GET("book")
    Call<Book> getBook();

    @GET("books")
    Call<ArrayList<Book>> getArrayBook();
}
