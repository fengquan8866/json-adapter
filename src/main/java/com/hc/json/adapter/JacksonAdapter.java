package com.hc.json.adapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 17:22
 */
public class JacksonAdapter implements JsonAdapter {
    private final ObjectMapper objMapper = new ObjectMapper();
    private final TypeFactory typeFactory = TypeFactory.defaultInstance();

    public JacksonAdapter() {
        // 空对象
        this.objMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 空属性
        this.objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 忽略null
        this.objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // LocalDateTime
        this.objMapper.findAndRegisterModules();

        JsonAdapterConfigManager.config(this.objMapper);
    }

    @Override
    public String toJson(Object object) throws JsonException {
        try {
            return this.objMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    @Override
    public <T> T fromJson(String jsonStr, Type type) throws JsonException {
        try {
            return this.objMapper.readValue(jsonStr, this.typeFactory.constructType(type));
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    @Override
    public <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonException {
        try {
            return this.objMapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    @Override
    public <T> List<T> fromJsonToList(String jsonStr, Class<T> clazz) throws JsonException {
        try {
            return this.objMapper.readValue(jsonStr, this.typeFactory.constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new JsonException(e);
        }
    }
}
