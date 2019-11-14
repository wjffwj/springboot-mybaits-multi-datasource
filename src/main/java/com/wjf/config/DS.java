package com.wjf.config;

import java.lang.annotation.*;

/**
 * 数据源注解类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DS {
    String value() default "readTestDb";
}
