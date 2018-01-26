package com.tywho.controller;

import com.tywho.annotation.IgnoreAuth;
import com.tywho.bean.AuthRequest;
import com.tywho.bean.AuthResponse;
import com.tywho.exception.BizExceptionEnum;
import com.tywho.exception.RRException;
import com.tywho.utils.JwtTokenUtil;
import com.tywho.utils.R;
import com.tywho.validator.IReqValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lty on 2018/1/25/0025.
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    @IgnoreAuth
    public R createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);

            return R.ok().put("data", new AuthResponse(token, randomKey));
        } else {
            throw new RRException(BizExceptionEnum.AUTH_REQUEST_ERROR.getMessage(), BizExceptionEnum.AUTH_REQUEST_ERROR.getCode());
        }
    }
}
