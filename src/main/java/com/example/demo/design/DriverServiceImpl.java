package com.example.demo.design;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/30 11:20
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class DriverServiceImpl implements IDriverService {
    @Override
    public void Driver(ICar car) {
        car.run();
    }
}
