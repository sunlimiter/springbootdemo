package com.tywho.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lty on 2018/1/25/0025.
 */
@Configuration
@ConfigurationProperties(prefix = RestProperties.REST_PREFIX)
public class RestProperties {

    public static final String REST_PREFIX = "rest";

    private boolean authOpen = true;

    private boolean signOpen = true;

    public boolean isAuthOpen() {
        return authOpen;
    }

    public void setAuthOpen(boolean authOpen) {
        this.authOpen = authOpen;
    }

    public boolean isSignOpen() {
        return signOpen;
    }

    public void setSignOpen(boolean signOpen) {
        this.signOpen = signOpen;
    }
}
