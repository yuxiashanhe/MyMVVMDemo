package com.example.mymode.utils;

import android.widget.Toast;

import com.example.mymode.application.DemoApplication;

public class ToastUtils {

    private static ToastUtils instance;

    public static ToastUtils getInstance(){
        if (instance == null){
            instance = new ToastUtils();
        }
        return instance;
    }

    private ToastUtils(){

    }

    public void showToast(String str){
        Toast.makeText(DemoApplication.getContent(), str, Toast.LENGTH_SHORT).show();
    }

}
