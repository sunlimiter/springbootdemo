package com.tywho.bean;

/**
 * Created by lty on 2018/1/25/0025.
 */
public class BaseRequestBean {
    private String object; //base64编码的json字符串

    private String sign;   //签名

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
