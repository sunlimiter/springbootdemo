package com.tywho.security;

/**
 * Created by lty on 2018/1/25/0025.
 */
public interface DataSecurityAction {

    /**
     * 执行数据的保护措施
     *
     * @author stylefeng
     * @Date 2017/9/18 20:42
     */
    String doAction(String beProtected);

    /**
     * 解除保护
     *
     * @author stylefeng
     * @Date 2017/9/18 20:45
     */
    String unlock(String securityCode);
}
