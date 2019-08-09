package com.example.demo.putong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/17 11:07
 * @Email: 15290810931@163.com
 */
@Data
@NoArgsConstructor
public class Phone {
    private String name;
    private int price;
    private String color;
    private String brand;

    public Phone(String name, int price,String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
}
