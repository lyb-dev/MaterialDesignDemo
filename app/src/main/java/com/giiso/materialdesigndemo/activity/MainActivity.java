package com.giiso.materialdesigndemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.giiso.materialdesigndemo.R;
import com.giiso.materialdesigndemo.base.BaseActivity;

import butterknife.BindView;

/**
 * 首页
 *
 * @author lyb-dev
 * @created 2017-03-17
 */
public class MainActivity extends BaseActivity {
    private final String Tag = this.getClass().getSimpleName();
    @BindView(R.id.tv_custom)
    TextView tvCustom;
    @BindView(R.id.Toolbar)
    Toolbar Toolbar;
    @BindView(R.id.fb)
    FloatingActionButton fb;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doNewIntent(getIntent(), true);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        doNewIntent(intent, false);
    }

    private void doNewIntent(Intent intent, boolean isCreat) {

    }

    @Override
    public void initView() {
        super.initView();
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "floatingbutton", Toast.LENGTH_SHORT).show();
            }
        });
        tvCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "自定义view被点击", Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar.inflateMenu(R.menu.toolbal_menu);
        Toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_notify: {
                        Toast.makeText(MainActivity.this, "通知", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.action_search: {
                        Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();

                        break;
                    }
                    case R.id.action_setting: {
                        Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();

                        break;
                    }
                    case R.id.action_share: {
                        Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();

                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
