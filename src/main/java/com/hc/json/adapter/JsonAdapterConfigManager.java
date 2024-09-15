package com.hc.json.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 15:28
 */
public class JsonAdapterConfigManager {
    private static final JsonAdapterConfigManager INSTANCE = new JsonAdapterConfigManager();
    private final List<JsonAdapterConfigure> configures = new ArrayList();

    private JsonAdapterConfigManager() {
        this.loadFromSPI();
    }

    static void config(Object o) {
        for (JsonAdapterConfigure configure : INSTANCE.configures) {
            configure.config(o);
        }
    }

    private void loadFromSPI() {
        for (JsonAdapterConfigure configure : ServiceLoader.load(JsonAdapterConfigure.class)) {
            this.configures.add(configure);
        }
    }
}
