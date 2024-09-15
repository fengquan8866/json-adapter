package com.hc.json.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 17:25
 */
public class GsonAdapter implements JsonAdapter {
    private final Gson gson;

    public GsonAdapter() {
        GsonBuilder builder = new GsonBuilder();
        JsonAdapterConfigManager.config(builder);
        this.gson = builder.create();
    }

    @Override
    public String toJson(Object object) throws JsonException {
        return this.gson.toJson(object);
    }

    @Override
    public <T> T fromJson(String jsonStr, Type type) throws JsonException {
        return this.gson.fromJson(jsonStr, type);
    }

    @Override
    public <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonException {
        return this.gson.fromJson(jsonStr, clazz);
    }

    @Override
    public <T> List<T> fromJsonToList(String jsonStr, Class<T> clazz) throws JsonException {
        return this.gson.fromJson(jsonStr, new ParameterizedType() {
            public Type[] getActualTypeArguments() {
                return new Type[]{clazz};
            }

            public Type getRawType() {
                return List.class;
            }

            public Type getOwnerType() {
                return null;
            }
        });
    }
}
