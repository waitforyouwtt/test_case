package com.example.demo.putong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:43
 * @Email: 15290810931@163.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String userName;

    private String password;

    private Integer state;

    private List<Roles> rolesList;

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
