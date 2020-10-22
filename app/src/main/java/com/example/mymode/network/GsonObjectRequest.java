package com.example.mymode.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.example.mymode.bean.BaseBean;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import androidx.annotation.Nullable;

public class GsonObjectRequest extends JsonRequest<BaseBean> {

    public GsonObjectRequest(int method, String url, @Nullable String requestBody, Response.Listener<BaseBean> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
    }

    @Override
    protected Response<BaseBean> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString =
                    new String(
                            response.data,
                            HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            return Response.success(
                    new Gson().fromJson(jsonString, BaseBean.class),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

}
