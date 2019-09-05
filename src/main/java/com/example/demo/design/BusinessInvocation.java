package com.example.demo.design;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/30 11:25
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class BusinessInvocation implements IBusinessInvocation{
    @Autowired
    IDriverService iDriverService;
    public void invocation(int type) {
        ICar iCar ;
        if (type == 1){
            iCar = new BenzCar();
            iDriverService.Driver(iCar);
        }else if(type == 2){
            iCar = new BMWCar();
            iDriverService.Driver(iCar);
        }
    }
}
