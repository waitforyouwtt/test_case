package com.example.demo;

import com.example.demo.putong.Roles;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.example.demo.Data.rolesList;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class ListTest extends DemoApplicationTests{

    @Test
    public void testA(){
        List<Roles> rolesList = rolesList();
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
}
