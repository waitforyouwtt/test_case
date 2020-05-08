package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Email;
import com.example.demo.putong.Phone;
import com.example.demo.putong.Roles;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;
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

    @Test
    public void getNo(){
        List<Phone> phoneList = this.phoneList;
        List<String> Lists = Arrays.asList("手机A","手机B","手机F");
        List<String> phones = new ArrayList<>();
        /* for (Phone phone: phoneList){
            for (String s: Lists){
                if (s.equals(phone.getName())){
                    phones.add(phone.getName());
                }
            }
        }
        System.out.println(phones);*/
        List<String> fdf = phoneList.stream().map(Phone::getName).collect(toList());
        Collection<String> result = getDiffrent(fdf, Lists);



        System.out.println("fd:{}"+result);

    }


    public static Collection<String> getDiffrent(Collection<String> col1, Collection<String> col2){
        //创建返回结果
        Collection<String> diffrentResult = new ArrayList<>();
        //比较出两个集合的大小，在添加进map的时候先遍历较大集合，这样子可以减少没必要的判断
        Collection<String> bigCol = null;
        Collection<String> smallCol = null;
        if (col1.size() > col2.size()) {
            bigCol = col1;
            smallCol = col2;
        }else {
            bigCol = col2;
            smallCol = col1;
        }
        //创建 Map<对象,出现次数> (直接指定大小减少空间浪费)
        Map<Object, Integer> map = new HashMap<>(bigCol.size());
        //遍历大集合把元素put进map，初始出现次数为1
        for(String p : bigCol) {
            map.put(p, 1);
        }
        //遍历小集合，如果map中不存在小集合中的元素，就添加到返回结果，如果存在，把出现次数置为2
        for(String p : smallCol) {
            if (map.get(p) == null) {
                diffrentResult.add(p);
            }else {
                map.put(p, 2);
            }
        }
        //把出现次数为1的 Key:Value 捞出，并把Key添加到返回结果
        for(Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diffrentResult.add((String) entry.getKey());
            }
        }
        return diffrentResult;
    }



    //---------------------



    @Test
    public void testList() {
        List<Phone> phoneList = this.phoneList;
        List<String> phoneNames = phoneList.stream().map(Phone::getName).collect(toList());
        List<String> Lists = Arrays.asList("手机A","手机B","手机F");

        //差集List
        List<String> defectList = new ArrayList<String>();

        //交集List
        List<String> collectionList = new ArrayList<String>();

        //去重并集List
        List<String> unionList = new ArrayList<String>();

        // 获取差集
        defectList = receiveDefectList(phoneNames, Lists);

        collectionList = receiveCollectionList(phoneNames, Lists);
        System.out.println(collectionList);

    }

    // 获取两个ArrayList的差集、交集、去重并集(数据量大小不限制)
    private static void getList() {
        List<String> firstArrayList = new ArrayList<String>();

        List<String> secondArrayList = new ArrayList<String>();

        List<String> defectList = new ArrayList<String>();//差集List
        List<String> collectionList = new ArrayList<String>();//交集List
        List<String> unionList = new ArrayList<String>();//去重并集List
        try {
            firstArrayList.add("aaa");
            firstArrayList.add("bbb");
            firstArrayList.add("ccc");
            firstArrayList.add("ddd");

            secondArrayList.add("bbb");
            secondArrayList.add("ccc");
            secondArrayList.add("eee");
            // 获取差集
            defectList = receiveDefectList(firstArrayList, secondArrayList);
            Iterator<String> defectIterator = defectList.iterator();
            System.out.println("===================差集===================");
            while(defectIterator.hasNext()) {
                System.out.println(defectIterator.next());
            }
            // 获取交集
            collectionList = receiveCollectionList(firstArrayList, secondArrayList);
            Iterator<String> collectionIterator = collectionList.iterator();
            System.out.println("===================交集===================");
            while(collectionIterator.hasNext()) {
                System.out.println(collectionIterator.next());
            }
            // 获取去重并集
            unionList = receiveUnionList(firstArrayList, secondArrayList);
            Iterator<String> unionIterator = unionList.iterator();
            System.out.println("===================去重并集===================");
            while(unionIterator.hasNext()) {
                System.out.println(unionIterator.next());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @方法描述：获取两个ArrayList的差集
     * @param firstArrayList 第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 差集ArrayList
     */
    public static List<String> receiveDefectList(List<String> firstArrayList, List<String> secondArrayList) {
        List<String> resultList = new ArrayList<String>();
        LinkedList<String> result = new LinkedList<String>(firstArrayList);// 大集合用linkedlist
        HashSet<String> othHash = new HashSet<String>(secondArrayList);// 小集合用hashset
        Iterator<String> iter = result.iterator();// 采用Iterator迭代器进行数据的操作
        while(iter.hasNext()){
            if(othHash.contains(iter.next())){
                iter.remove();
            }
        }
        resultList = new ArrayList<String>(result);
        return resultList;
    }

    /**
     * @方法描述：获取两个ArrayList的交集
     * @param firstArrayList 第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 交集ArrayList
     */
    public static List<String> receiveCollectionList(List<String> firstArrayList, List<String> secondArrayList) {
        List<String> resultList = new ArrayList<String>();
        LinkedList<String> result = new LinkedList<String>(firstArrayList);// 大集合用linkedlist
        HashSet<String> othHash = new HashSet<String>(secondArrayList);// 小集合用hashset
        Iterator<String> iter = result.iterator();// 采用Iterator迭代器进行数据的操作
        while(iter.hasNext()) {
            if(!othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        resultList = new ArrayList<String>(result);
        return resultList;
    }

    /**
     * @方法描述：获取两个ArrayList的去重并集
     * @param firstArrayList 第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 去重并集ArrayList
     */
    public static List<String> receiveUnionList(List<String> firstArrayList, List<String> secondArrayList) {
        List<String> resultList = new ArrayList<String>();
        Set<String> firstSet = new TreeSet<String>(firstArrayList);
        for(String id : secondArrayList) {
            // 当添加不成功的时候 说明firstSet中已经存在该对象
            firstSet.add(id);
        }
        resultList = new ArrayList<String>(firstSet);
        return resultList;
    }


}