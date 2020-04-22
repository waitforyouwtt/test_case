package com.example.demo;

import com.example.demo.putong.Email;
import com.example.demo.putong.Phone;
import com.example.demo.putong.Roles;
import com.example.demo.putong.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/4 18:29
 * @Email: 15290810931@163.com
 */
public class Data {

    public static List<Apple> appleList(){
        List<Apple> list = Arrays.asList(
                new Apple("red", 150,150)
                , new Apple("yellow", 140,140)
                , new Apple("green", 210,210)
                , new Apple("green", 210,210)
                , new Apple("yellow", 120,120)
                , new Apple("green", 170,170)
                , new Apple("green", 170,170)
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

    public static List<Phone> phoneList() {
        return Arrays.asList(
                new Phone("手机A", 87, "red"),
                new Phone("手机B", 21, "green"),
                new Phone("手机F", 22, "white"),
                new Phone("手机C", 22, "black"),
                new Phone("手机D", 23, "black"),
                new Phone("手机e", 22, "black")
        );
    }

    public static List<Email> emailList(){
        Date createD1 = DateTest.strToDateLong("2011-08-03 12:12:12");
        Date createD2 = DateTest.strToDateLong("2014-08-05 12:12:12");
        Date createD3 = DateTest.strToDateLong("2015-08-03 12:12:26");
        Date createD4 = DateTest.strToDateLong("2015-08-03 12:12:26");

        Date updateD1 = DateTest.strToDateLong("2011-08-03 12:12:12");
        Date updateD2 = DateTest.strToDateLong("2012-08-03 12:12:12");
        Date updateD3 = DateTest.strToDateLong("2013-08-03 12:12:12");
        Date updateD4 = DateTest.strToDateLong("2013-08-05 12:12:12");

        return Arrays.asList(
                new Email("1140867582@qq.com",20,true,createD1,updateD1),
                new Email("15290810931@163.com",25,false,createD2,updateD2),
                new Email("15290810931@163.com",25,false,createD4,updateD4),
                new Email("15290810932@163.com",25,false,createD3,updateD3),
                new Email("17621007255@163.com",25,false,createD2,updateD2),
                new Email("17621007255@163.com",25,false,createD2,updateD2),
                new Email("16601387337@163.com",25,false,createD2,updateD2)
                );
    }


    public static List<String> stringList(){
        return Arrays.asList("red","green","yellow","black");
    }


}
