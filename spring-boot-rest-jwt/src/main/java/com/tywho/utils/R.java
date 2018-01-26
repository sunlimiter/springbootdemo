package com.tywho.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lty on 2018/1/25/0025.
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("message", "请求正常");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("message", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("message", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public R put(Object value) {
        super.put("data", value);
        return this;
    }
}