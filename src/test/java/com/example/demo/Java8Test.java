package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Email;
import com.example.demo.putong.Phone;
import com.example.demo.putong.Roles;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.DateTest.DATE_TO_STRING_DEFAULT_PATTERN;
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
    public void summingTest() {
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
        Double collectDouble = apples.stream().collect(Collectors.summingDouble(Apple::getQuality));
        log.info("集合sum 计算的结果[双精度]:{}",collectDouble);
        int collectInteger = apples.stream().map(Apple::getQuality).mapToInt(Integer::intValue).sum();
        log.info("集合sum 计算的结果[整形]:{}",collectInteger);
        Long collectLong = apples.stream().collect(Collectors.summingLong(Apple::getQuality));
        log.info("集合sum 计算的结果[长整形]:{}",collectLong);
        Integer collectInt = apples.stream().collect(Collectors.summingInt(Apple::getQuality));
        LinkedList<Apple> collect = apples.stream().filter(d -> d.getQuality() > 150).collect(Collectors.toCollection(LinkedList::new));
        log.info("大于150的集合：{}",JSON.toJSON(collect));
        Set<Email> collectSetList = emails.stream().filter(Email::isStatus).collect(Collectors.toSet());
        log.info("去重：{}",collectSetList);
    }

    @Test
    public void toStreamTest(){
       Stream<Apple> appleStream = Stream.of(new Apple("red",20,20));
       apples.parallelStream().forEach(apple -> System.out.println(apple.getColor()));
       Collections.sort(apples,((o1, o2) -> Integer.compare(o1.getQuality(),o2.getQuality())));
       log.info("排序后的结果：{}",JSON.toJSON(apples));
       List<Apple> appleCollect = apples.stream().distinct().collect(toList());
       log.info("集合去重：{}",appleCollect);
        List<Apple> collectSkip = apples.stream().skip(5).collect(toList());
        log.info("越过前5个：{}",collectSkip);
        List<Apple> collectLimit = apples.stream().limit(2).collect(toList());
        log.info("集合中取两条记录：{}",collectLimit);
        Apple first = apples.stream().findFirst().get();
        log.info("得到第一个：{}",first);
        List<Apple> filterThenSort = apples.stream().filter(apple -> apple.getColor().equals("yellow")).sorted(Comparator.comparing(Apple::getQuality).reversed()).collect(toList());
        log.info("筛选后排序：{}",filterThenSort);
        apples.stream().filter(apple -> apple.getColor().equals("green")).distinct().sorted();

    }
    @Test
    public void fd8(){
        ArrayList<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] strings = new String[list.size()];
        list.toArray(strings);
        log.info("得到的数组：{}",JSON.toJSON(strings));
    }
    @Test
    public void fd9(){

    }
    @Test
    public void fd10(){
        List<String> strings = Arrays.asList("a","b","c","d","d");
        List<List<String>> partition = Lists.partition(strings, 2);
        log.info("得到的是啥：{}",partition);
    }
    @Test
    public void fd11(){
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()-15*24*60*60*1000);
        String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date startDate = strToDateLong(startTime);
        System.out.println(startDate +"哈哈哈哈");
        System.out.println(startTime);
        System.out.println("***************************");
        System.out.println(endTime);

    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TO_STRING_DEFAULT_PATTERN);
        return formatter.parse(strDate, new ParsePosition(0));
    }

    @Test
    public void fd12(){
        List<Phone> phoneList = Data.phoneList();
        List<Phone> nameNull = phoneList.stream().filter(apple -> apple.getName().equals("")).collect(toList());
        log.info("名字为空的集合：{}",JSON.toJSON(nameNull));
        List<Phone> nameNotNull = phoneList.stream().filter(apple -> !apple.getName().equals("")).collect(toList());
        log.info("名字不为空的集合：{}",JSON.toJSON(nameNotNull));
    }
    @Test
    public void fd13(){

    }
    @Test
    public void fd14(){
        log.info(getNowFormat());
        LocalDate today = LocalDate.now();
        //本月的第一天
        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
        //本月的最后一天
        LocalDate lastDay =today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天" + firstday);
        System.out.println("本月的最后一天" + lastDay);
    }

    public static String getNowFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return  df.format(new Date());
    }

    @Test
    public void fd1(){
      log.info(getLastDay().substring(0,6));
    }

    private static String getLastDay(){
        return   LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).toString().replace("-", "");
    }


    @Test
    public void fd16(){
      int fd =  Calendar.getInstance().get(Calendar.MONTH) + 1;
      log.info("fda:{}",fd);
    }
    @Test
    public void fd17(){
        String updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()-30*24*60*60*1000);
       log.info("大：{}",updateTime);
    }
    @Test
    public void fd162(){
        log.info(getDateForDayBefor());
    }

    public static String getDateForDayBefor() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -40);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String time = df.format(calendar.getTime());
        return time;
    }

    public String f32d(){
        Date date = new Date();//当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化对象
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期
        calendar.add(Calendar.MONTH, -2);//月份减一
        return sdf.format(calendar.getTime());
    }

    /**
     *   Set<String> locationSet = userVO.getOrganizations().stream().map(OrganizationVO::getLocationCode).collect(Collectors.toSet());
     locationCodeList.addAll(locationSet);
     locationCodeList.sort(Comparator.comparing(Function.identity()));
     */
    @Test
    public void fd32(){
        Set<String> setList = apples.stream().map(Apple::getColor).collect(Collectors.toSet());
    }

    @Test
    public void di(){
       /* List list = Arrays.asList("hello","word");
        String params = listToString(list,',');
        log.info("接受到的参数：{}",params);*/

        List<Long> list = Arrays.asList(5678L,7890L,1234L);
        String params = listToString(list,',');
        log.info("接受到的参数：{}",params);
    }

    public String listToString(List list, char separator) {
        return StringUtils.join(list.toArray(), separator);
    }

    @Test
    public void fd33(){
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");

        list2.add("g");
        list2.add("c");
        list2.add("b");
        list2.add("a");
        boolean b = list1.retainAll(list2);
        System.out.print(b);
    }

    @Test
    public void fd34(){

 /*       String month = "989343";
        Long months = Long.valueOf(month);
        log.info("结果：{}",months);*/

        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";

        log.info("a得到的值:{}",a);
        log.info("b得到的值：{}",b);
        log.info("aa得到的值：{}",aa);
        log.info("bb 得到的值：{}",bb);


    }

    @Test
    public void fdffs(){
      String music =  "李玉刚-更好遇见你";
      String singer = music.substring(0,music.indexOf("-"));
      log.info("得到的值：{}",singer);

    }

    @Test
    public void beep(){
        java.awt.Toolkit.getDefaultToolkit().beep();
    }


}