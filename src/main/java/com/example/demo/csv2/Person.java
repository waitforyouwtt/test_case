package com.example.demo.csv2;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 13:51
 * @Email: 15290810931@163.com
 */
@Data
public class Person implements Serializable {

    private String name;

    private int age;

    private int sex;

    private String phone;

    private String address;

}
