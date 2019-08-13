package com.example.demo;

import com.example.demo.putong.Phone;
import com.example.demo.putong.UserInfo;
import com.example.demo.putong.UserInfo2;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
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

    @Test
    public void copyTest() {
        List<UserInfo> userInfos = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            UserInfo userInfo = new UserInfo();
            userInfos.add(userInfo);
        }
        long start = System.currentTimeMillis();
        List<UserInfo2> userInfo2s = Lists.newArrayList();
        for (UserInfo u : userInfos){
            UserInfo2 u2 = new UserInfo2();
            BeanCopier beanCopier = BeanCopier.create(UserInfo.class,UserInfo2.class,false);
            beanCopier.copy(u,u2,null);
            userInfo2s.add(u2);
        }
        log.info("用户2：{}",userInfo2s);
        long costTime = System.currentTimeMillis() - start;
        log.info("花费的时间是：{}",costTime);
    }

    @Test
    public void setTest() {
        List<UserInfo> userInfos = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            UserInfo userInfo = new UserInfo();
            userInfos.add(userInfo);
        }
        long start = System.currentTimeMillis();
        List<UserInfo2> userInfo2s = Lists.newArrayList();
        for (UserInfo u : userInfos) {
            UserInfo2 u2 = new UserInfo2();
            u2.setUserName(u.getUserName());
            u2.setPassword(u.getPassword());
            u2.setRolesList(u.getRolesList());
            u2.setState(u.getState());
            userInfo2s.add(u2);
        }
        log.info("用户2：{}", userInfo2s);
        long costTime = System.currentTimeMillis() - start;
        log.info("花费的时间是：{}", costTime);
    }




}

