package com.example.jetpackmvvm.network;


import com.example.jetpackmvvm.callback.NetworkResposeListener;

public class NetworkUtil {
    public static String TAG = "Network";

    private static NetworkUtil instance;

    private BaseRequestManager requestManager;

    public static NetworkUtil getInstance(){
        if (instance == null){
            synchronized (NetworkUtil.class){
                if (instance == null){
                    instance = new NetworkUtil();
                }
            }
        }
        return instance;
    }

    private NetworkUtil(){
        //requestManager = RetrofitManager.getInstance();
        requestManager = VolleyManager.getInstance();
    }

    public void getWanandroidData(final NetworkResposeListener listener) {
        requestManager.requestData(listener);
    }

}
