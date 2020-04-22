package com.example.demo.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:30
 * @Email: 15290810931@163.com
 */
@Target({ElementType.METHOD,ElementType.TYPE})
// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
//说明该注解将被包含在javadoc中
@Documented
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface PersonAnnotation {
    
}
