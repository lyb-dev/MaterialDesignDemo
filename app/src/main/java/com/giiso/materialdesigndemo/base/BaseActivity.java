package com.giiso.materialdesigndemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.giiso.materialdesigndemo.interf.BaseViewInterface;

import butterknife.ButterKnife;

/** Activity 基类
 * Created by lyb-dev on 2017/3/17.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeSetContentLayout();
        setContentView(getContentView());
        ButterKnife.bind(this);
        init(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onBeforeSetContentLayout() {
    }

    protected abstract int getContentView();

    protected void initView() {
    }

    protected void initData() {
    }

    protected void init(Bundle savedInstanceState){

    }
}
