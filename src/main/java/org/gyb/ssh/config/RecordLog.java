package org.gyb.ssh.config;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 用于标识使用记录日志的注解，只能标注在Controller类的方法上，标注在其他地方无意义。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface RecordLog {
    @AliasFor("content")
    String value() default "";
    @AliasFor("value")
    String content() default "";
}
