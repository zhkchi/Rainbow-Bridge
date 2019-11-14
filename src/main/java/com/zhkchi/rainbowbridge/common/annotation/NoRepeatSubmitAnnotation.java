package com.zhkchi.rainbowbridge.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhkchi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoRepeatSubmitAnnotation {

    /**
     * 设置请求锁定时间
     *
     * @return 0 or 1
     */
    int lockTime() default 5;

}