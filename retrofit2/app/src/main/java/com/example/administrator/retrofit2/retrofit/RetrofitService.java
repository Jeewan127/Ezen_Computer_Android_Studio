package com.example.administrator.retrofit2.retrofit;

import com.example.administrator.retrofit2.network.NetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018-01-29.
 */

public class RetrofitService  {
    public static RetrofitService curr = null;
    private NetworkService networkService;  // 인터페이스 객체 선언

    // singleton 설정
    public static RetrofitService getInstance() {
        if(curr == null) {
            curr = new RetrofitService();
        }

        return curr;
    }

    // 생성자
    private RetrofitService() {
        networkService = init(); // 생성자에서 init() 실행
    }

    // 초기화 작업
    public NetworkService init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.141.201:8090/tbjars/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(NetworkService.class);
    }

    //
    public NetworkService getNetworkService() {
        return networkService;
    }
}
