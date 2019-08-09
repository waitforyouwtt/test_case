package com.example.demo.putong;

import lombok.Data;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:43
 * @Email: 15290810931@163.com
 */
@Data
public class UserInfo2 {

    private String userName;

    private String password;

    private Integer state;

    private List<Roles> rolesList;
}
