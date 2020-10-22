package com.example.jetpackmvvm.network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jetpackmvvm.application.DemoApplication;
import com.example.jetpackmvvm.bean.WandroidBean;
import com.example.jetpackmvvm.callback.NetworkResposeListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyManager extends BaseRequestManager {
    private static String TAG = "VolleyManager";

    private static VolleyManager instance;
    private RequestQueue requestQueue;

    public static VolleyManager getInstance() {
        if (instance == null){
            synchronized (VolleyManager.class){
                if (instance == null){
                    instance = new VolleyManager();
                }
            }
        }
        return instance;
    }

    private VolleyManager(){
        init();
    }

    private void init() {
        requestQueue = Volley.newRequestQueue(DemoApplication.getContent());
    }

    @Override
    void requestData(final NetworkResposeListener listener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                baseUrl + "/article/list/0/json",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        //泛型，未分离出数据转换
                        WandroidBean bean = new Gson().fromJson(response.toString(), WandroidBean.class);
                        if (listener != null){
                            listener.onSuccessCall(bean);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (listener != null){
                            listener.onFailCall(error);
                        }
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<>();
                headerMap.put("Content-Type", "application/json");
                headerMap.put("token","");
                return headerMap;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> paramsMap = new HashMap<>();
                return paramsMap;
            }
        };

        requestQueue.add(request);
    }
}
