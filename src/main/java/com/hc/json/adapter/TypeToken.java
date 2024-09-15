package com.hc.json.adapter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 17:35
 */
public abstract class TypeToken<T> {
    private final Type type;

    protected TypeToken() {
        Type superClass = this.getClass().getGenericSuperclass();
        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}
