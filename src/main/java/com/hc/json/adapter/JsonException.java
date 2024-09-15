package com.hc.json.adapter;

/**
 * @author huangchao E-mail:fengquan8866@163.com
 * @version 创建时间：2024/9/15 14:58
 */
public class JsonException extends RuntimeException {

    private static final long serialVersionUID = -7380835512946227302L;

    public JsonException() {
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(String message) {
        super(message);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }
}
