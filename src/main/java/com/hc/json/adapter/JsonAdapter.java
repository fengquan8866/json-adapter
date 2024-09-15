package com.hc.json.adapter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 14:55
 */
public interface JsonAdapter {

    /**
     * 将对象序列化为 JSON 字符串。
     *
     * @param object 要序列化的对象
     * @return 序列化后的 JSON 字符串
     * @throws JsonException 抛出异常
     */
    String toJson(Object object) throws JsonException;

    /**
     * 将 JSON 字符串反序列化为对象。
     *
     * @param jsonStr 要反序列化的 JSON 字符串
     * @param type    对象的类型
     * @param <T>     泛型类型
     * @return 反序列化后的对象
     * @throws JsonException 抛出异常
     */
    <T> T fromJson(String jsonStr, Type type) throws JsonException;

    /**
     * 将 JSON 字符串反序列化为对象。
     *
     * @param jsonStr 要反序列化的 JSON 字符串
     * @param clazz   对象的类
     * @param <T>     泛型类型
     * @return 反序列化后的对象
     * @throws JsonException 抛出异常
     */
    <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonException;

    /**
     * 将 JSON 字符串反序列化为对象列表。
     *
     * @param jsonStr 要反序列化的 JSON 字符串
     * @param clazz   对象的类
     * @param <T>     泛型类型
     * @return 对象列表
     * @throws JsonException 抛出异常
     */
    <T> List<T> fromJsonToList(String jsonStr, Class<T> clazz) throws JsonException;

}