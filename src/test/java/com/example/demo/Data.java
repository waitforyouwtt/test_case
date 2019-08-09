package com.example.demo;

import com.example.demo.putong.Phone;
import com.example.demo.putong.Roles;
import com.example.demo.putong.UserInfo;
import com.example.demo.sms.SingleSms;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/4 18:29
 * @Email: 15290810931@163.com
 */
public class Data {

    public static List<Apple> appleList(){
        List<Apple> list = Arrays.asList(
                new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170)
                , new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170)
        );
        return list;
    }

    public static List<Role> roleList (){
        List<Role> list = Arrays.asList(
          new Role(100,10),
                new Role(80,40),
                new Role(70,30)
        );
        return list;
    }

    public static SingleSms smsData(){
        SingleSms sms = new SingleSms();
        sms.setAppId("521");
        sms.setGzip("off");
        sms.setEncode("UTF-8");
        sms.setMobile("17621007255");
        sms.setContent("测试单条发送短信");
        sms.setTimerTime("2019-07-11 12:12:12");
        sms.setCustomSmsId("521");
        sms.setExtendedCode("321123");
        sms.setRequestTime(System.currentTimeMillis());
        sms.setRequestValidPeriod(1);
        return sms;
    }

    public static List<Roles> rolesList(){
        return new ArrayList<>(Arrays.asList(
                new Roles(1,"超级管理员"),
                new Roles(2,"普通管理员"),
                new Roles(3,"管理员"),
                new Roles(5,"操作员"),
                new Roles(5,"业务员"),
                new Roles(5,"业务员2")
        ));
    }

    public static UserInfo userInfo(){
        UserInfo userInfo = new UserInfo("凤凰小哥哥","521",1,rolesList());
        return userInfo;
    }

    public static List<Phone> phoneList(){
        return Arrays.asList(
                new Phone("手机D",23,"white"),
                new Phone("手机A",20,"red"),
                new Phone("手机A",87,"red"),
                new Phone("手机B",21,"green"),
                new Phone("手机C",22,"black"),
                new Phone("手机E",57,"black"),
                new Phone("手机F",66,"black")

                );
    }

    public static List<String> stringList(){
        return Arrays.asList("red","green","yellow","black");
    }


}
