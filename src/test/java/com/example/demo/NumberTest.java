package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:54
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class NumberTest extends DemoApplicationTests{

    @Test
    public void bigdecimal(){
        BigDecimal a = new BigDecimal("-3.33");
        BigDecimal b = new BigDecimal("4.44");

        if (a.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("等于");
        }else if(a.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("大于");
        }else if(a.compareTo(BigDecimal.ZERO) == -1) {
            System.out.println("小于");
        }
    }

    @Test
    public void ObjectTest(){
        Integer a = 1;
        Integer b = 1;
        int  aa = 1;
        int  bb = 1;

        if (a.equals(b)){
            log.info("等于");
        }else{
            log.info("不等于");
        }

        if (aa == bb){
            log.info("aa == bb");
        }else{
            log.info("aa != bb");
        }
    }

    @Test
    public void operatiorTest(){
        BigDecimal price = BigDecimal.valueOf(10.23);
        BigDecimal amount = price.multiply(BigDecimal.valueOf(100));
        int productPrice = amount.intValue();
        System.out.println("得到的金额："+productPrice);
    }
}
