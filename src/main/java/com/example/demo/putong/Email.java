package com.example.demo.putong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/13 14:52
 * @Email: 15290810931@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    private String email;

    private Integer length;

    private boolean status;

}
