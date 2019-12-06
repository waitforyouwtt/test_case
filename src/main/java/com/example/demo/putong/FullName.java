package com.example.demo.putong;

import lombok.Data;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/6 14:33
 * @Email: 15290810931@163.com
 */
@Data
public class FullName {
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", middleName="
                + middleName + ", lastName=" + lastName + "]";
    }
}
