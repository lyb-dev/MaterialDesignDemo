package com.giiso.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.giiso.materialdesigndemo.R;
import com.giiso.materialdesigndemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchViewActivity extends BaseActivity {

    @BindView(R.id.searchview)
    SearchView searchview;
    @BindView(R.id.tv_clear)
    TextView tvClear;

    @Override
    protected int getContentView() {
        return R.layout.activity_search_view;
    }

    @Override
    protected void initView() {
        searchview.post(new Runnable() {
            @Override
            public void run() {
//                TDevice.showSoftKeyboard(mViewSearch);
                searchview.setIconified(false);
            }
        });
    }

    @OnClick(R.id.tv_clear)
    public void onClick() {

    }
}
