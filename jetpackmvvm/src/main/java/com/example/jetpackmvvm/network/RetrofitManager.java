package com.example.jetpackmvvm.network;

import android.util.Log;


import com.example.jetpackmvvm.bean.WandroidBean;
import com.example.jetpackmvvm.callback.NetworkResposeListener;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager extends BaseRequestManager{

    private static String TAG = "RetrofitManager";
    private static RetrofitManager instance;
    private Retrofit retrofit;

    public static RetrofitManager getInstance() {
        if (instance == null){
            synchronized (RetrofitManager.class){
                if (instance == null){
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    private RetrofitManager(){
        init();
    }

    private void init(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private WanandroidPagesApi getURLApi(){
        return retrofit.create(WanandroidPagesApi.class);
    }

    public void requestData(final NetworkResposeListener listener){
        Call<WandroidBean> call = getURLApi().getWandroidPages();
        call.enqueue(new Callback<WandroidBean>() {
            @Override
            public void onResponse(Call<WandroidBean> call, Response<WandroidBean> response) {
                Log.i(TAG, call.request().toString());
                Log.i(TAG, response.body().toString());
                if (listener != null){
                    listener.onSuccessCall(response.body());
                }
            }

            @Override
            public void onFailure(Call<WandroidBean> call, Throwable t) {
                Log.e(TAG, call.request().url().toString());
                if (listener != null){
                    listener.onFailCall(t);
                }
            }
        });
    }



}
