package com.example.demo.entity;

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

    private String userName;

    private Integer age;

    private Date birthday;
}
