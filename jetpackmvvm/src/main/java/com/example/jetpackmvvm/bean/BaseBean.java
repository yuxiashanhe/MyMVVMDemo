package com.example.jetpackmvvm.bean;



import com.google.gson.Gson;

import androidx.annotation.NonNull;

public class BaseBean {

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
