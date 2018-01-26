package com.tywho.validator;

import com.tywho.validator.dto.Credence;

/**
 * Created by lty on 2018/1/25/0025.
 */
public interface IReqValidator {
    /**
     * 通过请求参数验证
     *
     * @author fengshuonan
     * @Date 2017/8/23 11:49
     */
    boolean validate(Credence credence);
}
