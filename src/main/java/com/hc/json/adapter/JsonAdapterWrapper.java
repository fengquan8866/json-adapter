package com.hc.json.adapter;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 15:43
 */
public class JsonAdapterWrapper implements JsonAdapter{
    private final JsonAdapter wrapper;

    public JsonAdapterWrapper(JsonAdapter wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String toJson(Object object) throws JsonException {
        if (object == null) {
            return null;
        }
        try {
            return this.wrapper.toJson(object);
        } catch (Exception e) {
            throw this.convertException(e);
        }
    }

    @Override
    public <T> T fromJson(String jsonStr, Type type) throws JsonException {
        if (isEmpty(jsonStr)) {
            return null;
        }
        try {
            return this.wrapper.fromJson(jsonStr, type);
        } catch (Exception e) {
            throw this.convertException(e);
        }
    }

    @Override
    public <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonException {
        if (isEmpty(jsonStr)) {
            return null;
        }
        try {
            return this.wrapper.fromJson(jsonStr, clazz);
        } catch (Exception e) {
            throw this.convertException(e);
        }
    }

    @Override
    public <T> List<T> fromJsonToList(String jsonStr, Class<T> clazz) throws JsonException {
        if (isEmpty(jsonStr)) {
            return null;
        }
        try {
            return this.wrapper.fromJsonToList(jsonStr, clazz);
        } catch (Exception e) {
            throw this.convertException(e);
        }
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private JsonException convertException(Exception e) {
        return e instanceof JsonException ? (JsonException)e : new JsonException(e);
    }
}
