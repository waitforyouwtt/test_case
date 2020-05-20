package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 13:42
 * @Email: 15290810931@163.com
 */
@Data
public class Roles implements Serializable {

    private int id;

    private String roleName;


    public Roles(int i, String 管理员) {
    }
}
