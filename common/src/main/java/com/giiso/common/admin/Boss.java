package com.giiso.common.admin;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.giiso.common.R;
import com.giiso.common.utils.HashUtil;
import com.giiso.common.utils.NativeUtil;

public final class Boss extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private static int mClickCount;
    private static long mClickLastTime = System.currentTimeMillis();
    private static boolean mAllowEnter = false;

    public static void verifyApp(Context context) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - mClickLastTime) < 260) {
            mClickCount++;
        } else {
            mClickCount = 0;
        }
        mClickLastTime = currentTime;
        if (mClickCount >= 10) {
            mAllowEnter = true;
            Intent intent = new Intent(context, Boss.class);
            context.startActivity(intent);
        }
    }

    private EditText mKey;
    private TextView mToken;
    private long mLastClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss);

        if (!mAllowEnter)
            finish();
        else {
            mAllowEnter = false;
            mKey = (EditText) findViewById(R.id.edt_key);
            mToken = (TextView) findViewById(R.id.txt_token);

            mToken.setOnClickListener(this);
            mToken.setOnLongClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {
        mToken.clearFocus();
        InputMethodManager manager = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(mToken.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


        long currentTime = System.currentTimeMillis();
        if ((currentTime - mLastClick) < 260) {
            checkAndGetToken();
        }
        mLastClick = currentTime;
    }

    @Override
    public boolean onLongClick(View view) {
        String token = mToken.getText().toString();
        if (TextUtils.isEmpty(token))
            return false;
        else {
            ClipboardManager cmb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data = ClipData.newPlainText("AppTokenKey", token);
            cmb.setPrimaryClip(data);
            Toast.makeText(this, "Copy done!", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private void checkAndGetToken() {
        String key = mKey.getText().toString().trim();
        if (TextUtils.isEmpty(key)) {
            Toast.makeText(this, "Your key is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        // Load native so before call native method
        NativeUtil.doLoadNative();
        String token = native_checkKeyToGetToken(getApplication(), HashUtil.getMD5(key));
        if (TextUtils.isEmpty(token))
            Toast.makeText(this, "Your key is error!", Toast.LENGTH_SHORT).show();
        else
            mToken.setText(token);
    }

    private static native String native_checkKeyToGetToken(Application application, String keyMd5);
}
