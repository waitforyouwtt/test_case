package com.example.demo.annotation;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:34
 * @Email: 15290810931@163.com
 */
@Component
@Aspect
@Order(2)
@Slf4j
public class PersonAspect {

    private final static String SAVE_PERSON_METHOD = "savePerson";

    private final static String UPDATE_PERSON_METHOD = "updatePerson";

    @Around(value = "@annotation(PersonAnnotation)")
    public Object interceptUpdatePrice(ProceedingJoinPoint pjp) {
        Object result = new Object();
        Method targetMethod = ((MethodSignature) (pjp.getSignature())).getMethod();
        String methodName = targetMethod.getName();
        log.info("method name ####{}", methodName);
        Object[] args = pjp.getArgs();

        try{
            result = pjp.proceed(args);
            //可以拿到结果
            sendMessage(methodName, args, result);
        }catch (Throwable throwable){
            throwable.getMessage();
        }
        return result;
    }

    private void sendMessage(String methodName, Object[] args, Object ret) {
        switch(methodName){
            case SAVE_PERSON_METHOD:
                PersonVO person = (PersonVO) args[0];
                log.info("切面得到的参数：{}", JSON.toJSONString(person));

                log.info("做自己想做的新增");
                break;
            case UPDATE_PERSON_METHOD:
                log.info("做自己想做的修改");
                break;
                default:
                    break;
        }
    }
}
