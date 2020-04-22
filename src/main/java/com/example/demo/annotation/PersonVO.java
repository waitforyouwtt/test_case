package com.example.demo.annotation;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/26 17:44
 * @Email: 15290810931@163.com
 */
@Data
public class PersonVO implements Serializable {

    private Integer id;

    private String userName;

    private Integer gender;
}
