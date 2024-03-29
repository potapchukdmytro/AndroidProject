package com.example.firstproject.service;

import com.example.firstproject.constants.Urls;
import com.example.firstproject.interceptors.JWTInterceptor;
import com.example.firstproject.network.AccountApi;
import com.example.firstproject.network.CategoriesApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationNetwork {
    private static ApplicationNetwork instance;
    private Retrofit retrofit;

    public ApplicationNetwork() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new JWTInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(Urls.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApplicationNetwork getInstance() {
        if (instance == null) {
            instance = new ApplicationNetwork();
        }
        return instance;
    }

    public CategoriesApi getJsonApi() {
        return retrofit.create(CategoriesApi.class);
    }

    public AccountApi getAccountApi() {
        return retrofit.create(AccountApi.class);
    }
}
