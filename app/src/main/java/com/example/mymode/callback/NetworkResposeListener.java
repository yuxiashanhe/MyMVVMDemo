package com.example.mymode.callback;

public interface NetworkResposeListener<DATA> {

    void onSuccessCall(DATA data);

    void onFailCall(Throwable t);
}
