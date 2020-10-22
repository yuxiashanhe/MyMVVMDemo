package com.example.jetpackmvvm.network;


import com.example.jetpackmvvm.callback.NetworkResposeListener;

abstract class BaseRequestManager<DATA> {

    protected static String baseUrl = "https://www.wanandroid.com/";

    abstract void requestData(final NetworkResposeListener<DATA> listener);

}
