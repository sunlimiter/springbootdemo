package com.tywho.utils;

import com.alibaba.fastjson.JSON;
import com.tywho.exception.BizExceptionEnum;
import com.tywho.exception.RRException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lty on 2018/1/25/0025.
 */
public class RenderUtil {

    /**
     * 渲染json对象
     */
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(jsonObject));
        } catch (IOException e) {
            throw new RRException(BizExceptionEnum.RENDERJSON_ERROR.getMessage(), BizExceptionEnum.RENDERJSON_ERROR.getCode());
        }
    }
}
