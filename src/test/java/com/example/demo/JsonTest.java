package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.putong.*;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class JsonTest extends DemoApplicationTests{

    @Test
    public void fastJson(){
        String hello = "  你好啊   ";
        log.info("str 去掉空格：{}",stringTrim(hello) );
    }

    private String  stringTrim(String str){
        str = str.trim();
        while (str.startsWith("　")) {//这里判断是不是全角空格
            str = str.substring(1, str.length()).trim();
        }
        while (str.endsWith("　")) {
            str = str.substring(0, str.length() - 1).trim();
        }
        return str;
    }

    @Test
    public void strings(){
        List <String> strings = Arrays.asList("苹果","橘子","葡萄");
        String goodsIdStr = String.join(",", strings);
        log.info("得到的结果：{}",goodsIdStr);
    }

    @Test
    public void json(){
        Map map = new HashMap();
        map.put("syncY","Y");
        map.put("success","true");
        System.out.println(map.toString());
    }

    @Test
    public void fdf(){

        Map map = new HashMap();

        map.put("code","1010");

        Fruit fruit = new Fruit();
        Apple apple = new Apple("red",150L,1);
        Apple apple2 = new Apple("yellow",160L,2);
        List<Apple> apples = new ArrayList<>();
        apples.add(apple);
        apples.add(apple2);
        fruit.setAppleList(apples);
        StringBuffer result = new StringBuffer();
            // red^1 | yellow^2

        for(int i = 0 ; i < fruit.getAppleList().size();i++){
            Apple   apple1 = fruit.getAppleList().get(i);
            result.append(apple1.getColor());
            result.append("^");
            result.append(apple1.getQuality());
            if(i < fruit.getAppleList().size()-1  ){
                result.append("|");
            }
        }

        map.put("color","red");
        map.put("fruit",result.toString());
        log.info("得到的结果：{}",map.toString());
    }

    @Test
    public void bigDecimalgetTest(){
        BigDecimal decimal = new BigDecimal("1.12345");
        String setScale = decimal.setScale(2,BigDecimal.ROUND_DOWN).toString();
        System.out.println("金额保留2位小数："+setScale);

       /* System.out.println(setScale);

        BigDecimal setScale1 = decimal.setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);*/
    }
}
