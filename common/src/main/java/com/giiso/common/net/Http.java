package com.giiso.common.net;


import com.giiso.common.net.io.IOParam;
import com.giiso.common.net.io.Param;
import com.giiso.common.net.io.StrParam;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 简单的请求封装
 */
public class Http<T> {
    private Deliver<T> mDeliver;

    private Http(Deliver<T> deliver) {
        mDeliver = deliver;
    }

    public static <T> Http<T> create(Deliver<T> deliver) {
        return new Http<>(deliver);
    }

    public Deliver<T> getDeliver() {
        return mDeliver;
    }


    /**
     * ============GET SYNC===============
     */
    public String getSync(String url) {
        return getSync(url, new StrParam[0]);
    }

    public String getSync(String url, StrParam... strParams) {
        return getSync(String.class, url, strParams);
    }

    public String getSync(String url, Object tag) {
        return getSync(String.class, url, tag);
    }

    public <T> T getSync(Class<T> tClass, String url) {
        return getSync(tClass, url, new StrParam[0]);
    }

    public <T> T getSync(Class<T> tClass, String url, StrParam... strParams) {
        return getSync(tClass, url, null, strParams);
    }

    public <T> T getSync(Class<T> tClass, String url, List<StrParam> strParams) {
        return getSync(tClass, url, null, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T getSync(Class<T> tClass, String url, Map<String, String> params) {
        return getSync(tClass, url, null, Util.mapToStringParams(params));
    }

    public <T> T getSync(Class<T> tClass, String url, Object tag) {
        return getSync(tClass, url, tag, new StrParam[0]);
    }

    public <T> T getSync(Class<T> tClass, String url, Object tag, StrParam... strParams) {
        return executeGetSync(tClass, null, url, tag, strParams);
    }

    public <T> T getSync(Class<T> tClass, String url, Object tag, List<StrParam> strParams) {
        return getSync(tClass, url, tag, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T getSync(Class<T> tClass, String url, Object tag, Map<String, String> params) {
        return getSync(tClass, url, tag, Util.mapToStringParams(params));
    }

    public <T> T getSync(String url, Callback<T> callback) {
        return getSync(url, null, callback);
    }

    public <T> T getSync(String url, Object tag, Callback<T> callback) {
        return getSync(url, tag, callback, new StrParam[0]);
    }

    public <T> T getSync(String url, Callback<T> callback, StrParam... strParams) {
        return getSync(url, null, callback, strParams);
    }

    public <T> T getSync(String url, Callback<T> callback, List<StrParam> strParams) {
        return getSync(url, null, callback, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T getSync(String url, Callback<T> callback, Map<String, String> params) {
        return getSync(url, null, callback, Util.mapToStringParams(params));
    }

    public <T> T getSync(String url, Object tag, Callback<T> callback, StrParam... strParams) {
        return executeGetSync(null, callback, url, tag, strParams);
    }

    public <T> T getSync(String url, Object tag, Callback<T> callback, List<StrParam> strParams) {
        return getSync(url, tag, callback, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T getSync(String url, Object tag, Callback<T> callback, Map<String, String> params) {
        return getSync(url, tag, callback, Util.mapToStringParams(params));
    }


    /**
     * ============GET ASYNC===============
     */
    public void getAsync(String url, Callback callback) {
        getAsync(url, callback, new StrParam[0]);
    }

    public void getAsync(String url, Callback callback, StrParam... strParams) {
        getAsync(url, null, callback, strParams);
    }

    public void getAsync(String url, Callback callback, List<StrParam> strParams) {
        getAsync(url, null, callback, Util.listToParams(strParams, StrParam.class));
    }

    public void getAsync(String url, Callback callback, Map<String, String> params) {
        getAsync(url, null, callback, Util.mapToStringParams(params));
    }

    public void getAsync(String url, Object tag, Callback callback) {
        getAsync(url, tag, callback, new StrParam[0]);
    }

    public void getAsync(String url, Object tag, Callback callback, StrParam... strParams) {
        executeGetAsync(callback, url, tag, strParams);
    }

    public void getAsync(String url, Object tag, Callback callback, List<StrParam> strParams) {
        getAsync(url, tag, callback, Util.listToParams(strParams, StrParam.class));
    }

    public void getAsync(String url, Object tag, Callback callback, Map<String, String> params) {
        getAsync(url, tag, callback, Util.mapToStringParams(params));
    }

    /**
     * ============POST SYNC===============
     */
    public String postSync(String url, List<StrParam> strParams) {
        return postSync(String.class, url, null, Util.listToParams(strParams, StrParam.class));
    }

    public String postSync(String url, Map<String, String> params) {
        return postSync(String.class, url, null, Util.mapToStringParams(params));
    }

    public String postSync(String url, StrParam... strParams) {
        return postSync(String.class, url, null, strParams);
    }

    public <T> T postSync(Class<T> tClass, String url, List<StrParam> strParams) {
        return postSync(tClass, url, null, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T postSync(Class<T> tClass, String url, Map<String, String> params) {
        return postSync(tClass, url, null, Util.mapToStringParams(params));
    }

    public <T> T postSync(Class<T> tClass, String url, StrParam... strParams) {
        return postSync(tClass, url, null, strParams);
    }

    public <T> T postSync(Class<T> tClass, String url, Object tag, List<StrParam> strParams) {
        return postSync(tClass, url, tag, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T postSync(Class<T> tClass, String url, Object tag, Map<String, String> params) {
        return postSync(tClass, url, tag, Util.mapToStringParams(params));
    }

    public <T> T postSync(Class<T> tClass, String url, Object tag, StrParam... strParams) {
        return executeGetSync(tClass, null, url, tag, strParams);
    }

    public <T> T postSync(String url, Callback<T> callback, List<StrParam> strParams) {
        return postSync(url, null, callback, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T postSync(String url, Callback<T> callback, Map<String, String> params) {
        return postSync(url, null, callback, Util.mapToStringParams(params));
    }

    public <T> T postSync(String url, Callback<T> callback, StrParam... strParams) {
        return postSync(url, null, callback, strParams);
    }

    public <T> T postSync(String url, Object tag, Callback<T> callback, List<StrParam> strParams) {
        return postSync(url, tag, callback, Util.listToParams(strParams, StrParam.class));
    }

    public <T> T postSync(String url, Object tag, Callback<T> callback, Map<String, String> params) {
        return postSync(url, tag, callback, Util.mapToStringParams(params));
    }

    public <T> T postSync(String url, Object tag, Callback<T> callback, StrParam... strParams) {
        return executeGetSync(null, callback, url, tag, strParams);
    }

    /**
     * ============POST ASYNC===============
     */
    public void postAsync(String url, final Callback callback, List<StrParam> strParams) {
        postAsync(url, null, callback, Util.listToParams(strParams, StrParam.class));
    }

    public void postAsync(String url, final Callback callback, Map<String, String> params) {
        postAsync(url, null, callback, Util.mapToStringParams(params));
    }

    public void postAsync(String url, final Callback callback, StrParam... strParams) {
        postAsync(url, null, callback, strParams);
    }

    public void postAsync(String url, Object tag, final Callback callback, List<StrParam> strParams) {
        postAsync(url, tag, callback, Util.listToParams(strParams, StrParam.class));
    }

    public void postAsync(String url, Object tag, final Callback callback, Map<String, String> params) {
        postAsync(url, tag, callback, Util.mapToStringParams(params));
    }

    public void postAsync(String url, Object tag, final Callback callback, StrParam... strParams) {
        executePostAsync(callback, url, tag, strParams);
    }

    public void postAsync(String url, final Callback callback, String bodyStr) {
        postAsync(url, null, callback, bodyStr);
    }

    public void postAsync(String url, Object tag, final Callback callback, String bodyStr) {
        executePostAsync(callback, url, tag, bodyStr);
    }

    public void postAsync(String url, final Callback callback, byte[] bytes) {
        postAsync(url, null, callback, bytes);
    }

    public void postAsync(String url, Object tag, final Callback callback, byte[] bytes) {
        executePostAsync(callback, url, tag, bytes);
    }

    public void postAsync(String url, final Callback callback, File file) {
        postAsync(url, null, callback, file);
    }

    public void postAsync(String url, Object tag, final Callback callback, File file) {
        executePostAsync(callback, url, tag, file);
    }

    public void postAsync(String url, final Callback callback, JSONObject jsonObject) {
        postAsync(url, null, callback, jsonObject);
    }

    public void postAsync(String url, Object tag, final Callback callback, JSONObject jsonObject) {
        executePostAsync(callback, url, tag, jsonObject);
    }

    public void postAsync(String url, final Callback callback, JSONArray jsonArray) {
        postAsync(url, null, callback, jsonArray);
    }

    public void postAsync(String url, Object tag, final Callback callback, JSONArray jsonArray) {
        executePostAsync(callback, url, tag, jsonArray);
    }

    /**
     * ============UPLOAD ASYNC===============
     */

    public void uploadAsync(String url, String key, File file, Callback callback) {
        uploadAsync(url, null, callback, new IOParam(key, file));
    }

    public void uploadAsync(String url, Object tag, String key, File file, Callback callback) {
        uploadAsync(url, tag, callback, new IOParam(key, file));
    }

    public void uploadAsync(String url, Callback callback, IOParam... params) {
        uploadAsync(url, null, callback, null, params);
    }

    public void uploadAsync(String url, Object tag, Callback callback, IOParam... params) {
        uploadAsync(url, tag, callback, null, params);
    }

    public void uploadAsync(String url, Callback callback, Param... params) {
        uploadAsync(url, null, callback, params);
    }

    public void uploadAsync(String url, Object tag, Callback callback, Param... params) {
        List<IOParam> IOParams = new ArrayList<>();
        List<StrParam> stringStrParams = new ArrayList<>();
        if (params != null && params.length > 0) {
            for (Param param : params) {
                if (param.isFile()) {
                    IOParams.add(param.getFileParam());
                } else {
                    stringStrParams.add(param.getStringParam());
                }
            }
        }
        uploadAsync(url, tag, callback,
                Util.listToParams(stringStrParams, StrParam.class),
                Util.listToParams(IOParams, IOParam.class));
    }

    public void uploadAsync(String url, Callback callback, StrParam[] strParams, IOParam... IOParams) {
        uploadAsync(url, null, callback, strParams, IOParams);
    }

    public void uploadAsync(String url, Object tag, Callback callback, StrParam[] strParams, IOParam... IOParams) {
        executeUploadAsync(callback, url, tag, strParams, IOParams);
    }


    /**
     * ============Execute============
     */
    private <T> T executeGetSync(Class<T> tClass, Callback<T> callback, String url, Object tag, StrParam... strParams) {
        return mDeliver.executeGet(false, callback, url, tag, strParams);
    }

    private void executeGetAsync(Callback callback, String url, Object tag, StrParam... strParams) {
        mDeliver.executeGet(true, callback, url, tag, strParams);
    }


    protected void executePostAsync(Callback callback, String url, Object tag, StrParam... params) {
        mDeliver.executePost(true, callback, url, tag, params);
    }

    protected void executePostAsync(Callback callback, String url, Object tag, String str) {

    }

    protected void executePostAsync(Callback callback, String url, Object tag, byte[] bytes) {

    }

    protected void executePostAsync(Callback callback, String url, Object tag, File file) {

    }

    protected void executePostAsync(Callback callback, String url, Object tag, JSONObject jsonObject) {

    }

    protected void executePostAsync(Callback callback, String url, Object tag, JSONArray jsonArray) {

    }

    protected void executeUploadAsync(Callback callback, String url, Object tag, StrParam[] strParams, IOParam... IOParams) {

    }


}
