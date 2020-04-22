package com.example.demo.design.pattern;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/21 11:04
 * @Email: 15290810931@163.com
 */
@Data
public class ProductOnline implements Serializable {

    private Byte transformType;

    private String productName;
}
