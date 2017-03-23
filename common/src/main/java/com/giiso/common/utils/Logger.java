package com.giiso.common.utils;

import android.util.Log;
/**
 * Created by qiujuer
 * on 2016/10/28.
 */
public final class Logger {
    public static boolean DEBUG = true;

    public static void d(String tag, String msg) {
        if (DEBUG)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG)
            Log.e(tag, msg);
    }
}
