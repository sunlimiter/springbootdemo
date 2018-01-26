package com.tywho.utils;

import java.util.Map;

/**
 * Created by lty on 2018/1/25/0025.
 */
public class StringUtils {
    public static String mapToQueryString(Map<String, Object> params) {
        String formData;
        StringBuilder encodedParams = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            encodedParams.append(entry.getKey());
            encodedParams.append('=');
            encodedParams.append(entry.getValue());
            encodedParams.append('&');
        }
        formData = encodedParams.toString();
        if (formData.endsWith("&")) {
            formData = formData.substring(0, formData.lastIndexOf("&"));
        }
        return formData;
    }
}
