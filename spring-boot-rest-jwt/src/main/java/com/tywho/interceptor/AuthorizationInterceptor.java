package com.tywho.interceptor;

import com.alibaba.fastjson.JSON;
import com.tywho.annotation.IgnoreAuth;
import com.tywho.bean.BaseRequestBean;
import com.tywho.exception.BizExceptionEnum;
import com.tywho.properties.JwtProperties;
import com.tywho.security.DataSecurityAction;
import com.tywho.utils.*;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by lty on 2018/1/26/0026.
 */

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    DataSecurityAction dataSecurityAction;

    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IgnoreAuth ignoreAuth;
        if (handler instanceof HandlerMethod) {
            ignoreAuth = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        //如果有@IgnoreAuth注解，则不验证token
        if (ignoreAuth != null) {
            return true;
        }
        if (checkToken(request, response)) {
            try {
                return checkSign(request, response);
            } catch (Exception ex) {
                RenderUtil.renderJson(response, R.error(BizExceptionEnum.SIGN_ERROR.getCode(), BizExceptionEnum.SIGN_ERROR.getMessage()));
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkSign(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = request;

        ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);

        InputStream in = requestWrapper.getInputStream();
        BaseRequestBean baseRequestBean = JSON.parseObject(in, BaseRequestBean.class);
        //校验签名
        String token = httpServletRequest.getHeader(jwtProperties.getHeader()).substring(7);

        String md5KeyFromToken = jwtTokenUtil.getMd5KeyFromToken(token);

        String object = baseRequestBean.getObject();
        String json = dataSecurityAction.unlock(object);
        String encrypt = MD5Util.encrypt(object + md5KeyFromToken);

        if (!encrypt.equals(baseRequestBean.getSign())) {
            RenderUtil.renderJson(response, R.error(BizExceptionEnum.SIGN_ERROR.getCode(), BizExceptionEnum.SIGN_ERROR.getMessage()));
            return false;
        }
        return true;
    }

    private boolean checkToken(HttpServletRequest request, HttpServletResponse response) {
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);

            //验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);
                if (flag) {
                    RenderUtil.renderJson(response, R.error(BizExceptionEnum.TOKEN_EXPIRED.getCode(), BizExceptionEnum.TOKEN_EXPIRED.getMessage()));
                    return false;
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                RenderUtil.renderJson(response, R.error(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
                return false;
            }
        } else {
            //header没有带Bearer字段
            RenderUtil.renderJson(response, R.error(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
            return false;
        }
        return true;
    }
}
