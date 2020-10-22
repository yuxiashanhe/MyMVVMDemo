package com.example.jetpackmvvm.activity;


import android.os.Bundle;
import android.util.Log;

import com.example.jetpackmvvm.R;
import com.example.jetpackmvvm.base.BaseActivity;
import com.example.jetpackmvvm.bean.WandroidBean;
import com.example.jetpackmvvm.callback.NetworkResposeListener;
import com.example.jetpackmvvm.network.NetworkUtil;
import com.example.jetpackmvvm.utils.ToastUtils;


public class NewsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        badingView();
        getData();
    }

    private void badingView(){
        setContentView(R.layout.activity_news);
    }

    private void getData() {
        NetworkUtil.getInstance().getWanandroidData(new NetworkResposeListener<WandroidBean>() {
            @Override
            public void onSuccessCall(WandroidBean wandroidBean) {
                Log.i("NewsActivity", wandroidBean.toString());
                ToastUtils.getInstance().showToast(wandroidBean.toString());


            }

            @Override
            public void onFailCall(Throwable t) {
                Log.e("NewsActivity", t.getMessage());
            }
        });

    }
}
