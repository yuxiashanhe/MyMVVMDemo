package com.example.mymode.network;


import com.example.mymode.callback.NetworkResposeListener;

abstract class BaseRequestManager<DATA> {

    protected static String baseUrl = "https://www.wanandroid.com/";

    abstract void requestData(final NetworkResposeListener<DATA> listener);

}
