/*
 * Copyright (C) 2014-2016 Qiujuer <qiujuer@live.cn>
 * WebSite http://www.qiujuer.net
 * Author Qiujuer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.giiso.common.net.io;

/**
 * Param to string
 */
public class StrParam {
    public String key;
    public String value;

    public StrParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public StrParam(String key, int value) {
        this(key, String.valueOf(value));
    }

    public StrParam(String key, float value) {
        this(key, String.valueOf(value));
    }

    public StrParam(String key, long value) {
        this(key, String.valueOf(value));
    }

    public StrParam(String key, double value) {
        this(key, String.valueOf(value));
    }
}
