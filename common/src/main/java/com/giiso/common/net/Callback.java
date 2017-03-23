package com.giiso.common.net;


import com.giiso.common.utils.Logger;

import java.lang.reflect.Type;

/**
 * Created by qiujuer
 * on 2016/11/29.
 */
public abstract class Callback<T> implements DispatchRequestProgress, DispatchResponseProgress {
    protected void dispatchStart(final Object request) {
        onStart(request);
    }

    protected void dispatchFinish() {
        onFinish();
    }

    protected void dispatchFailure(Object request, Object response, Exception e) {
        onFailure(request, response, e);
    }

    protected void dispatchSuccess(T response, int code) {
        onSuccess(response, code);
    }

    public void onStart(Object request) {
    }

    public void onFinish() {
    }

    public abstract void onFailure(Object request, Object response, Exception e);

    public abstract void onSuccess(T response, int code);

    @SuppressWarnings("unchecked")
    Class<T> getReturnClass() {
        try {
            Type[] types = new Type[]{getClass()};//Reflector.getActualTypeArguments(Callback.class, this.getClass());
            return (Class<T>) types[0];
        } catch (RuntimeException e) {
            if (Logger.DEBUG)
                e.printStackTrace();
            return null;
        }
    }

    public void onRequestProgress(long current, long count) {
    }

    public void onResponseProgress(long current, long count) {
    }


    @Override
    public void dispatchRequestProgress(long current, long count) {
        onRequestProgress(current, count);
    }

    @Override
    public void dispatchResponseProgress(long current, long count) {
        onResponseProgress(current, count);
    }
}
