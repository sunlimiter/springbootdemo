package com.tywho.validator.impl;

import com.tywho.validator.IReqValidator;
import com.tywho.validator.dto.Credence;
import org.springframework.stereotype.Service;

/**
 * Created by lty on 2018/1/25/0025.
 */
@Service
public class SimpleValidator implements IReqValidator {

    private static String USER_NAME = "admin";

    private static String PASSWORD = "admin";

    @Override
    public boolean validate(Credence credence) {

        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        if (USER_NAME.equals(userName) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
