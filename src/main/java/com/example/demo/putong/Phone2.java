package com.example.demo.putong;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/17 11:07
 * @Email: 15290810931@163.com
 */
@Data
@NoArgsConstructor
public class Phone2 {
    private TypeEnum2 name;

    public TypeEnum2 getName() {
        return name;
    }

    public void setName(TypeEnum2 name) {
        this.name = name;
    }
}
