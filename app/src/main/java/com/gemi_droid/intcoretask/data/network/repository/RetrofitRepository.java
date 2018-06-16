package com.gemi_droid.intcoretask.data.network.repository;

import android.content.Context;

import com.gemi_droid.intcoretask.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {

    Retrofit retrofit;

    public Retrofit getRetrofit(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(context.getString(R.string.base_url))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOKHTTPClient())
                    .build();
        }
        return retrofit;
    }


    public static okhttp3.OkHttpClient getOKHTTPClient() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient();
        client = client.newBuilder().addInterceptor(httpLoggingInterceptor)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();
        return client;


    }
}
