package com.example.demo.putong;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/23 14:32
 * @Email: 15290810931@163.com
 */
@Data
@AllArgsConstructor
public class ProductCombinedItem implements Serializable {

    private String sapProductCode;

    private Integer sapProductCount;
}
