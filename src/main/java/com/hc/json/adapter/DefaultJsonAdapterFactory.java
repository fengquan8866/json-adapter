package com.hc.json.adapter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 15:34
 */
public class DefaultJsonAdapterFactory implements JsonAdapterFactory {
    @Override
    public JsonAdapter create() {
        JsonAdapter jsonProvider = this.getSPIJsonProvider();
        if (jsonProvider != null) {
            return jsonProvider;
        }
        Class<JsonAdapter> clazz = this.getJsonProviderClass();
        if (clazz == null) {
            throw new NullPointerException("JsonProvider cannot found");
        }
        try {
            jsonProvider = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("JsonProvider instance create failed", e);
        }

        return new JsonAdapterWrapper(jsonProvider);
    }

    private Class<JsonAdapter> getJsonProviderClass() {
        Class<JsonAdapter> clazz = null;

        for (BuiltInJsonProviderProbe probe : this.getJsonProviderProbes()) {
            try {
                Class.forName(probe.probeClass);
                clazz = (Class<JsonAdapter>) Class.forName(probe.jsonProviderClass);
                break;
            } catch (Exception ignored) {
            }
        }

        return clazz;
    }

    private List<BuiltInJsonProviderProbe> getJsonProviderProbes() {
        return Arrays.asList(
                new BuiltInJsonProviderProbe("com.fasterxml.jackson.databind.ObjectMapper", JacksonAdapter.class.getName()),
                new BuiltInJsonProviderProbe("com.google.gson.Gson", GsonAdapter.class.getName()),
                new BuiltInJsonProviderProbe("com.alibaba.fastjson.JSON", FastJsonAdapter.class.getName()));
    }

    private JsonAdapter getSPIJsonProvider() {
        JsonAdapter provider = null;
        ServiceLoader<JsonAdapter> serviceLoader = ServiceLoader.load(JsonAdapter.class);

        for (Iterator<JsonAdapter> it = serviceLoader.iterator(); it.hasNext(); ) {
            JsonAdapter each = it.next();
            if (provider != null) {
                throw new RuntimeException(JsonAdapter.class + " extension class already exists [" + provider.getClass() + "], so it cannot load another [" + each.getClass() + "]");
            }
            provider = each;
        }

        return provider;
    }

    private static class BuiltInJsonProviderProbe {
        private final String probeClass;
        private final String jsonProviderClass;

        private BuiltInJsonProviderProbe(String probeClass, String jsonProviderClass) {
            this.probeClass = probeClass;
            this.jsonProviderClass = jsonProviderClass;
        }
    }
}
