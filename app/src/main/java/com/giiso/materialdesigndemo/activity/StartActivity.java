package com.giiso.materialdesigndemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.giiso.materialdesigndemo.R;
import com.giiso.materialdesigndemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class StartActivity extends BaseActivity {

    @BindView(R.id.bt_toolbar)
    Button btToolbar;
    @BindView(R.id.bt_textinputlayout)
    Button btTextinputlayout;

    @Override
    protected int getContentView() {
        return R.layout.activity_start;
    }

    @OnClick({R.id.bt_toolbar, R.id.bt_textinputlayout,R.id.bt_searchview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_toolbar:{
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.bt_textinputlayout:{
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.bt_searchview:{
                Intent intent = new Intent(this,SearchViewActivity.class);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
    }
}
