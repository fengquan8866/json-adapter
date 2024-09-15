package com.hc.json.adapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 15:05
 */
public class FastJsonAdapter implements JsonAdapter {
    private final SerializeConfig serializeConfig = new SerializeConfig();
//    private static final SerializerFeature[] FEATURES = new SerializerFeature[]{SerializerFeature.WriteClassName};

    public FastJsonAdapter() {
        JsonAdapterConfigManager.config(this.serializeConfig);
    }

    @Override
    public String toJson(Object object) throws JsonException {
        return JSON.toJSONString(object, serializeConfig);
    }

    @Override
    public <T> T fromJson(String jsonStr, Type type) throws JsonException {
        return JSON.parseObject(jsonStr, type, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    @Override
    public <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonException {
        return JSON.parseObject(jsonStr, clazz);
    }

    @Override
    public <T> List<T> fromJsonToList(String jsonStr, Class<T> clazz) throws JsonException {
        return JSON.parseArray(jsonStr, clazz);
    }
}
