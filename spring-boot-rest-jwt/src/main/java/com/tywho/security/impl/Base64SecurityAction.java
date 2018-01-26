package com.tywho.security.impl;

import com.tywho.security.DataSecurityAction;
import org.springframework.util.Base64Utils;

/**
 * Created by lty on 2018/1/25/0025.
 */
public class Base64SecurityAction implements DataSecurityAction {

    @Override
    public String doAction(String beProtected) {
        return Base64Utils.encodeToString(beProtected.getBytes());
    }

    @Override
    public String unlock(String securityCode) {
        byte[] bytes = Base64Utils.decodeFromString(securityCode);
        return new String(bytes);
    }
}