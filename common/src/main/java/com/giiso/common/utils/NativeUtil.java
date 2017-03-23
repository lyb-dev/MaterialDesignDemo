package com.giiso.common.utils;

/**
 * Native 工具类
 * <p>
 * Author: JuQiu qiujuer@live.cn
 */
public final class NativeUtil {
    /***
     * 当前Common库加载native的方法
     */
    public static void doLoadNative() {
        try {
            System.loadLibrary("osc-common-debug-lib");
        } catch (UnsatisfiedLinkError error) {
            System.loadLibrary("osc-common-lib");
        }
    }
}
