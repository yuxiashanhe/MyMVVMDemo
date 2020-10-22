package com.example.mymode.application;

import android.app.Application;
import android.util.Log;

public class DemoApplication extends Application {

    private static DemoApplication context;

    public static DemoApplication getContent(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Application","Application create");
        context = this;
    }



}
