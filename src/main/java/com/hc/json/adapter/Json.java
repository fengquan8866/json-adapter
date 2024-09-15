package com.hc.json.adapter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 14:55
 */
public class Json {
    private static final JsonAdapter ADAPTER = new DefaultJsonAdapterFactory().create();

    public static String toJson(Object object) throws JsonException {
        return ADAPTER.toJson(object);
    }

    public static <T> T fromJson(String jsonStr, Type type) throws JsonException {
        return ADAPTER.fromJson(jsonStr, type);
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonException {
        return ADAPTER.fromJson(jsonStr, clazz);
    }

    public static <T> List<T> fromJsonToList(String jsonStr, Class<T> clazz) throws JsonException {
        return ADAPTER.fromJsonToList(jsonStr, clazz);
    }
}
