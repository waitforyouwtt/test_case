package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 13:41
 * @Email: 15290810931@163.com
 */
@Data
@Builder
public class UserInfo implements Serializable {

    private String userName;

    private Integer age;

    private Date birthday;

    private List<Roles> rolesList;

}
