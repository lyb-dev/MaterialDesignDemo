package com.giiso.common.net;


import com.giiso.common.net.io.StrParam;

/**
 * Created by qiujuer
 * on 2016/11/29.
 */
public abstract class Deliver<Client> {
    Client client;

    public Client getClient() {
        return client;
    }

    public abstract <T> T executeGet(boolean isAsync,
                                     Callback<T> callback,
                                     String url,
                                     Object tag,
                                     StrParam... strParams);

    public abstract <T> T executePost(boolean isAsync,
                                      Callback<T> callback,
                                      String url,
                                      Object tag,
                                      StrParam... strParams);
}
