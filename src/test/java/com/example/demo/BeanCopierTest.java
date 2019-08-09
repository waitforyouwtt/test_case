package com.example.demo;

import com.example.demo.putong.UserInfo;
import com.example.demo.putong.UserInfo2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 14:02
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class BeanCopierTest extends DemoApplicationTests{

    @Test
    public void beanCopierTest(){
        UserInfo userInfo = new UserInfo("张洁","521",1,Data.rolesList());
        UserInfo2 userInfo2 = new UserInfo2();
        BeanCopier beanCopier = BeanCopier.create(UserInfo.class,UserInfo2.class,false);
        beanCopier.copy(userInfo,userInfo2,null);
        log.info("得到的结果：{}",userInfo2.toString());
        int type = 1;
        if(type == 1){

        }else {
            userInfo2.setUserName("小胖子凹凸曼");
        }

        log.info("得到的结果：{}",userInfo2.toString());

    }




}

