package com.library.service.api;

import com.google.gson.GsonBuilder;
import com.library.service.api.interceptor.CustomInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface APIService {
    Retrofit BUILDER = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
//            .baseUrl("http://10.251.0.222:8000/")
            .client(new OkHttpClient.Builder().addInterceptor(new CustomInterceptor()).build())
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd").create()))
            .build();
}
