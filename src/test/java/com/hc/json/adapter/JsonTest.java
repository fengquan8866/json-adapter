package com.hc.json.adapter;

import org.junit.Test;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 17:29
 */
public class JsonTest {

    @Test
    public void toJson() {
        String json = Json.toJson(new User("zsf", 18));
        System.out.println(json);
    }

    @Test
    public void fromJson() {
        String json = "{\"name\":\"zsf\",\"age\":18}";
        User user = Json.fromJson(json, User.class);
        System.out.println(user);
    }
}
