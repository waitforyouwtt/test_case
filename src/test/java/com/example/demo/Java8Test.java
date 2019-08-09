package com.example.demo;

import com.example.demo.putong.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class Java8Test extends DemoApplicationTests {

    /**
     * 筛选出条件为....的数据
     */
    @Test
    public void filterTest() {
        List<Phone> phoneList = Data.phoneList();
        List<Phone> green = phoneList.stream().filter(apple -> apple.getColor().equals("green")).collect(Collectors.toList());
        log.info("筛选出条件为....的数据：{}", green);
    }

    /**
     * 根据字段进行排序
     */
    @Test
    public void comparingTest() {
        List<Phone> phoneList = Data.phoneList();
        phoneList.sort(Comparator.comparing(Phone::getPrice).reversed());
        System.out.println("根据字段进行排序后的结果：{}" + phoneList);
    }

    /**
     * 查找一组数据中最大的值
     */
    @Test
    public void arrayFilterMaxTest() {
        List<Phone> phoneList = Data.phoneList();
        Optional<Phone> collect = phoneList.stream().collect(Collectors.maxBy(Comparator.comparing(Phone::getPrice)));
        if (collect.isPresent()) {
            Phone phone = collect.get();
            log.info("查找一组数据中最大的值:{}", phone);
        } else {
            log.info("没有数据");
        }
    }

    /**
     * 根据某字段进行分组,取出每一组中最大的值
     */
    @Test
    public void arrayGroupByFiledFilterMaxTest() {
        List<Phone> phoneList = Data.phoneList();
        Map<String, List<Phone>> map = phoneList.stream().collect(groupingBy(Phone::getColor));
        map.forEach((k, v) -> {
            Optional<Phone> collect = v.stream().collect(Collectors.maxBy(Comparator.comparing(Phone::getPrice)));
            if (collect.isPresent()) {
                Phone phone = collect.get();
                log.info("查找一组数据中最大的值:{}", phone);
            }
        });
    }
}