package com.example.demo.uml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/4/14 10:12
 * @Email: 15290810931@163.com
 */
@Service
public class PayService extends ExtendServer implements IPayService {

    @Autowired
    private PayGateWayComponent payGateWayComponent;

    @Override
    public void pay() {

    }
}
