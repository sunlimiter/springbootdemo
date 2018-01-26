package com.tywho.config;

import com.tywho.security.DataSecurityAction;
import com.tywho.security.impl.Base64SecurityAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lty on 2018/1/25/0025.
 */

@Configuration
public class JWTConfig {

    @Bean
    public DataSecurityAction dataSecurityAction() {
        return new Base64SecurityAction();
    }
}
