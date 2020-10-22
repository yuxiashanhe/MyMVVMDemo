package com.example.jetpackmvvm.callback;

public interface NetworkResposeListener<DATA> {

    void onSuccessCall(DATA data);

    void onFailCall(Throwable t);
}
