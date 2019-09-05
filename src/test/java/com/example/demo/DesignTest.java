package com.example.demo;

import com.example.demo.design.IBusinessInvocation;
import com.example.demo.putong.UserInfo;
import com.example.demo.putong.UserInfo2;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 14:02
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class DesignTest extends DemoApplicationTests{
    @Autowired
    IBusinessInvocation iBusinessInvocation;
    @Test
    public void fd(){
        iBusinessInvocation.invocation(1);
    }
}

