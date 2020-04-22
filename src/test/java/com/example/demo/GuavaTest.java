package com.example.demo;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/3/16 10:05
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class GuavaTest extends DemoApplicationTests  {

    @Test
    public void jbcTest(){

        Set<Integer> sets = Sets.newHashSet(1, 2, 3, 4, 5, 6);
        Set<Integer> sets2 = Sets.newHashSet(1,2,3,4);

        // 交集
        System.out.println("交集为：");
        Sets.SetView<Integer> intersection = Sets.intersection(sets, sets2);
        for (Integer temp : intersection) {
            System.out.println(temp);
        }
        // 差集
        System.out.println("差集为：");
        Sets.SetView<Integer> diff = Sets.difference(sets, sets2);
        for (Integer temp : diff) {
            System.out.println(temp);
        }
        // 并集
        System.out.println("并集为：");
        Sets.SetView<Integer> union = Sets.union(sets, sets2);
        for (Integer temp : union) {
            System.out.println(temp);
        }
    }

    @Test
    public void fdf(){
            String text = "22,2,7,19,21";
            if (!text.contains("27")){
              log.info("error");
            }else{
                log.info("right");
            }

           // System.out.println(match(text));
    }
    private  boolean match(String text){
        Pattern pattern = Pattern.compile("(22|2|7|19|21)");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            System.out.println("匹配到了："+matcher.group(1));
            return true;
        }
        System.out.println("没有匹配到");
        return false;
    }
}
