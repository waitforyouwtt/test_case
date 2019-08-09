package com.example.demo;

import com.example.demo.putong.Roles;
import com.example.demo.putong.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class ListTest extends DemoApplicationTests{

    /**
     * 集合去重
     */
    @Test
    public void querydistinctList(){
        List<Integer> integers = Data.rolesList().stream().map(Roles::getId).distinct().collect(Collectors.toList());
        System.out.println("得到的数据："+integers);
    }

    @Test
    public void testA(){
        List<Roles> rolesList = Data.rolesList();
        long count = rolesList.stream().distinct().count();
        boolean isRepeat = count < rolesList.size();
        System.out.println(count);//输出2

        List<Integer> integers = rolesList.stream().map(Roles::getId).collect(Collectors.toList());
        long idCount = integers.stream().distinct().count();
        boolean repeat = idCount < integers.size();
        System.out.println(idCount);
        if(repeat){
            System.out.println(true);//输出true 拥有重复值
        }else{
            System.out.println(false);//输出true  没有重复值
        }

        if(isRepeat){
            System.out.println(true);//输出true 拥有重复值
        }else{
            System.out.println(false);//输出true  没有重复值
        }

        Map<String, List<Roles>> map = rolesList.stream().collect(Collectors.groupingBy(o -> o.getRoleName().concat(String.valueOf(o.getId()))));

        map.forEach((k,v)->{
            if (v.size()>1){
                System.out.println("存在重复值："+k);
            }else{
                System.out.println("不存在重复值");
            }
        });
    }

    /**
     * 过滤
     * @throws Exception
     */
    @Test
    public void filterTest() throws Exception {
        List<UserInfo> list = new ArrayList<UserInfo>(Arrays.asList(
                new UserInfo("zhangsan","1234"),
                new UserInfo("lisi","56789"),
                new UserInfo("wangwu","00000")));

        list.stream().forEach(u -> {
            //此处是对遍历出来的对象进行操作
            System.out.println(u.toString());
        });


        List<UserInfo> resultList = new ArrayList<UserInfo>();
        resultList = list.stream().filter(e -> !e.getUserName().equals("zhangsan") && !e.getUserName().equals("lisi")).collect(Collectors.toList());
        //再遍历出来
        resultList.stream().forEach(stu -> {
            System.out.println(stu.toString());
        });
    }

    @Test
    public void queryListMapTest(){
        UserInfo userInfo = Data.userInfo();
        List<Integer> rolesIds = userInfo.getRolesList().stream().map(Roles::getId).collect(Collectors.toList());
        System.out.println("获取的结果：{}"+rolesIds);
    }
}
