package com.tywho.exception;

import com.tywho.utils.R;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by lty on 2018/1/25/0025.
 */
@RestControllerAdvice
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e) {
        // 打印 报错堆栈轨迹
        System.out.println("handleRRException");
        return R.error(e.getCode(), e.getMsg());
    }

    /**
     * 拦截jwt相关异常
     */
    @ExceptionHandler(JwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public R jwtException(JwtException e) {
        return R.error(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        // 打印 报错堆栈轨迹
        e.printStackTrace();
        logger.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }
}
