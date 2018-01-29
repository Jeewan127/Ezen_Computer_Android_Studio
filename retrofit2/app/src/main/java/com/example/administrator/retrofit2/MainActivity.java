package com.example.administrator.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.retrofit2.data.ArrayBook;
import com.example.administrator.retrofit2.data.Book;
import com.example.administrator.retrofit2.data.RetrofitResult;
import com.example.administrator.retrofit2.network.NetworkService;
import com.example.administrator.retrofit2.retrofit.RetrofitService;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    NetworkService networkService;

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.retrofit_bin1) // 이 버튼을 클릭했을때
    public void onClickBtnGet(View view) {
        Call<RetrofitResult> obser = RetrofitService.getInstance().getNetworkService().getRetrofitResult();

        obser.enqueue(new Callback<RetrofitResult>() {
            @Override
            public void onResponse(Call<RetrofitResult> call, Response<RetrofitResult> response) {
                if(response.isSuccessful()) {
                    RetrofitResult retrofitResult = response.body();
                    Log.d("ksj",retrofitResult.toString());
                }
            }

            @Override
            public void onFailure(Call<RetrofitResult> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @OnClick(R.id.retrofit_bin2)
    public void onClickBtnBook(View view) {
        Call<Book> books = RetrofitService.getInstance().getNetworkService().getBook();

        books.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if(response.isSuccessful()) {
                    Book book = response.body();
                    Log.d("ksj", book.toString());
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @OnClick(R.id.retrofit_bin3)
    public void onClickBtnArrayBook(View view) {
        Call<ArrayList<Book>> arraybooks = RetrofitService.getInstance().getNetworkService().getArrayBook();

        arraybooks.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                if(response.isSuccessful()) {
                    ArrayList<Book> arrayBook = response.body();
                    for (int i=0; i<arrayBook.size(); i++) {
                        Log.d("ksj", i + " " + arrayBook.get(i).toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });
    }
}
