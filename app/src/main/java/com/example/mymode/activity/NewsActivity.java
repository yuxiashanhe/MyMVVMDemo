package com.example.mymode.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.mymode.R;
import com.example.mymode.base.BaseActivity;
import com.example.mymode.bean.WandroidBean;
import com.example.mymode.callback.NetworkResposeListener;
import com.example.mymode.databinding.ActivityNewsBinding;
import com.example.mymode.network.NetworkUtil;
import com.example.mymode.utils.ToastUtils;
import com.example.mymode.viewmode.NewsViewMode;

public class NewsActivity extends BaseActivity {

    private ActivityNewsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        badingView();
        getData();
    }

    private void badingView(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news);

    }

    private void getData() {
        NetworkUtil.getInstance().getWanandroidData(new NetworkResposeListener<WandroidBean>() {
            @Override
            public void onSuccessCall(WandroidBean wandroidBean) {
                Log.i("NewsActivity", wandroidBean.toString());
                ToastUtils.getInstance().showToast(wandroidBean.toString());

                NewsViewMode mode = new NewsViewMode();
                mode.name = wandroidBean.getData().getDatas().get(0).getChapterName();
                binding.setVMode(mode);
            }

            @Override
            public void onFailCall(Throwable t) {
                Log.e("NewsActivity", t.getMessage());
            }
        });

    }
}
