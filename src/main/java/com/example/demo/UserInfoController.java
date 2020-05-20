package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luoxian
 * @Date: 2020/5/19 14:55
 * @Email: 15290810931@163.com
 */
@RestController
public class UserInfoController {

    @PostMapping("/message")
    public String getMessage(@RequestParam("orderId") String orderId){
       String order =  getClass().getName()+ orderId;
       return order;
    }
}
