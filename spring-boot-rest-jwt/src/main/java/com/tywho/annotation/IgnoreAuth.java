package com.tywho.annotation;

import java.lang.annotation.*;

/**
 * Created by lty on 2018/1/26/0026.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}