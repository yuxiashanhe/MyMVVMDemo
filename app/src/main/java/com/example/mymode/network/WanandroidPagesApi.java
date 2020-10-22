package com.example.mymode.network;


import com.example.mymode.bean.WandroidBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WanandroidPagesApi {

    @GET("/article/list/0/json")
    Call<WandroidBean> getWandroidPages();

}
