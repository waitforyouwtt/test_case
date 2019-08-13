package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Email;
import com.example.demo.putong.Phone;
import com.example.demo.putong.Roles;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class Java8Test extends DemoApplicationTests {

    List<Phone> phoneList = Data.phoneList();
    List<Apple> apples = Data.appleList();
    List<Email> emails = Data.emailList();
    /**
     * 筛选出条件为....的数据
     */
    @Test
    public void filterTest() {

        List<Phone> green = phoneList.stream().filter(apple -> apple.getColor().equals("green")).collect(toList());
        log.info("筛选出条件为....的数据：{}", green);
    }

    /**
     * 根据字段进行排序
     */
    @Test
    public void comparingTest() {
        phoneList.sort(Comparator.comparing(Phone::getPrice).reversed());
        System.out.println("根据字段进行排序后的结果：{}" + phoneList);
    }

    /**
     * 查找一组数据中最大的值
     */
    @Test
    public void arrayFilterMaxTest() {
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
        Map<String, List<Phone>> map = phoneList.stream().collect(groupingBy(Phone::getColor));
        map.forEach((k, v) -> {
            Optional<Phone> collect = v.stream().collect(Collectors.maxBy(Comparator.comparing(Phone::getPrice)));
            if (collect.isPresent()) {
                Phone phone = collect.get();
                log.info("查找一组数据中最大的值:{}", phone);
            }
        });
    }

    /**
     * 集合去重
     */
    @Test
    public void distinctList(){
        List<Integer> integers = Data.rolesList().stream().map(Roles::getId).distinct().collect(toList());
        System.out.println("得到的数据："+integers);
    }

    /**
     * 根据颜色进行分组
     */
    @Test
    public void groupingByTest(){
        Map<String, List<Apple>> map = apples.stream().collect(Collectors.groupingBy(Apple::getColor));
        map.forEach((k,v)->{
            log.info("得到的结果：{}", JSON.toJSON(v.toString()));
        });
    }

    /**
     * 根据某列取出一组数据中最大的一条记录
     */
    @Test
    public void getMax(){
        Optional<Apple> optionalApple = apples.stream().reduce((apple, apple2) -> apple.getWeight() > apple2.getWeight() ? apple : apple2);
        Optional<Apple> optionalApple2 = apples.stream().collect(Collectors.maxBy(Comparator.comparingInt(Apple::getQuality)));
        if (optionalApple.isPresent()){
            Apple apple = optionalApple.get();
            log.info("得到的最大值：{}",apple);
        }else{
            log.info("么有");
        }
    }

    /**
     * 获取集合的size
     */
    @Test
    public void listLength(){
        Integer collect = apples.stream().collect(Collectors.collectingAndThen(toList(), t -> t.size()));
        log.info("获取集合的size：{}",collect);
    }

    /**
     * 根据某列进行分组，然后求出每组的平均值
     */
    @Test
    public void groupThenAvg(){
        Map<String, Double> collect = apples.stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.averagingInt(Apple::getQuality)));
        log.info("得到的结果：{}",JSON.toJSON(collect));
    }
    @Test
    public void summaryTest(){
        //求平均数
        Double collectDouble = apples.stream().collect(Collectors.averagingDouble(Apple::getQuality));
        Double collectInt = apples.stream().collect(Collectors.averagingInt(Apple::getQuality));
        Double collectLong = apples.stream().collect(Collectors.averagingLong(Apple::getQuality));
        String collectThenDo = apples.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Apple::getQuality), aDouble -> "你好"));
        log.info("{},双精度：{},{},整形：{},{},长整形：{},{},计算之后然后todo:{}","\n",collectDouble,"\n",collectInt,"\n",collectLong,"\n",collectThenDo);
        //统计
        Long collectCount = apples.stream().collect(Collectors.counting());
        log.info("集合的个数：{}",collectCount);
        Map<String, Double> collectGroupThenAvg = apples.stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.averagingInt(Apple::getQuality)));
        log.info("分组后，分别计算每组的平均值：{}",collectGroupThenAvg);
        TreeMap<String, Double> groupThenAvgAndSort = apples.stream().collect(Collectors.groupingBy(Apple::getColor, TreeMap::new, Collectors.averagingInt(Apple::getQuality)));
        log.info("分组后，分别计算每组的平均值和排序：{}",groupThenAvgAndSort);
        IntSummaryStatistics summary = apples.stream().collect(Collectors.summarizingInt(Apple::getQuality));
        log.info("集合的各种聚合函数值：{}",summary);
    }
    @Test
    public void summaryConcurrentTest(){
        ConcurrentMap<String, List<Apple>> collectGroup = apples.stream().collect(Collectors.groupingByConcurrent(Apple::getColor));
        ConcurrentMap<String, Double> collectGroupAvg = apples.stream().collect(Collectors.groupingByConcurrent(Apple::getColor, Collectors.averagingInt(Apple::getQuality)));
        ConcurrentMap<String, Double> collectGroupAvgSkip = apples.stream().collect(Collectors.groupingByConcurrent(Apple::getColor, ConcurrentSkipListMap::new, Collectors.averagingInt(Apple::getQuality)));
        log.info("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");

        String collectJoin = apples.stream().map(Apple::getColor).collect(Collectors.joining());
        log.info("取某列进行拼接：{}",collectJoin);
        String collectCommaJoin = apples.stream().map(Apple::getColor).collect(Collectors.joining(","));
        log.info("取某列用逗号进行拼接：{}",collectCommaJoin);
        String collectCommaJoinHeadAndEnd = apples.stream().map(Apple::getColor).collect(Collectors.joining(",", "Names[", "]"));
        log.info("取某列用逗号进行拼接，且前后加前缀：{}",collectCommaJoinHeadAndEnd);
        String collectMapping = apples.stream().collect(Collectors.mapping(Apple::getColor, Collectors.joining(",")));
        Optional<Apple> collectMax = apples.stream().collect(Collectors.maxBy(Comparator.comparingInt(Apple::getQuality)));
        Optional<Apple> collectMin = apples.stream().collect(Collectors.minBy(Comparator.comparingInt(Apple::getQuality)));
        log.info("集合中的最大记录:{}，集合中的最小记录:{}",collectMax,collectMin);
    }
    @Test
    public void fd5() {
        Map<Boolean, List<Email>> collectBoolean = emails.stream().collect(Collectors.partitioningBy(Email::isStatus));
        Optional<Email> collect = emails.stream().collect(Collectors.reducing(
                BinaryOperator.maxBy(Comparator.comparingInt(Email::getLength))
        ));
        log.info("取集合中最大的一条记录：{}", JSON.toJSON(collect));
        Integer sum = apples.stream().map(Apple::getQuality).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        log.info("集合中某一列的sum ：{}",sum);
        Integer result = apples.stream().collect(Collectors.reducing(0, Apple::getQuality, (d1, d2) -> d1 + d2));
        log.info("集合中某一列的sum ：{}",result);
    }
    @Test
    public void fd6(){

    }
    @Test
    public void fd7(){

    }
    @Test
    public void fd8(){

    }
    @Test
    public void fd9(){

    }
    @Test
    public void fd10(){

    }
    @Test
    public void fd11(){

    }
    @Test
    public void fd12(){

    }
    @Test
    public void fd13(){

    }
    @Test
    public void fd14(){

    }
    @Test
    public void fd1(){

    }
    @Test
    public void fd16(){

    }
    @Test
    public void fd17(){

    }
    @Test
    public void fd162(){

    }
    @Test
    public void f32d(){

    }
    @Test
    public void fd32(){

    }
}