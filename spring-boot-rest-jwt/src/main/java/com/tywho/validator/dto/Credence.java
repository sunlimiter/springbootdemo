package com.tywho.validator.dto;

/**
 * Created by lty on 2018/1/25/0025.
 */
public interface Credence {

    /**
     * 凭据名称
     */
    String getCredenceName();

    /**
     * 密码或者是其他的验证码之类的
     */
    String getCredenceCode();
}
