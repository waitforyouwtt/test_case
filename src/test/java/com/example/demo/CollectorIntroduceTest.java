package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/4 18:26
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class CollectorIntroduceTest extends DemoApplicationTests{

    @Test
    public void TipTest(){
        List<Role> roleList = Data.roleList();
        List<Role> A = roleList.stream().sorted((o1, o2) -> o1.getFullPrice() - o2.getFullPrice()).collect(Collectors.toList());
        List<Role> B = roleList.stream().sorted((o1, o2) -> o1.getSubPrice() - o2.getSubPrice()).collect(Collectors.toList());

        if (A.equals(B)){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }

       /* if (CollectionUtils.isEqualCollection(A,B)){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }*/


       /* roleList.sort((o1, o2) -> o1.getFullPrice() - o2.getFullPrice());

        roleList.forEach(role -> System.out.println(role));*/
    }

    @Test
    public void timeTest(){
        long time = System.currentTimeMillis();
        log.info("获取的时间：{}",time);

        Double number = 7832.5675789;
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        log.info("四舍五入保留三位小数：{}",decimalFormat.format(number));

        long time1 = new Date().getTime();

        log.info("好烦啊：{}",time1);
    }

    @Test
    public void gbkTest() throws UnsupportedEncodingException {
        String t = "验证码【577521】，打死不要告诉别人哦";
        String utf8 = new String(t.getBytes( "UTF-8"));
        System.out.println(utf8);
        String unicode = new String(utf8.getBytes(),"UTF-8");
        System.out.println(unicode);
        String gbk = new String(unicode.getBytes("GBK"));
        System.out.println(gbk);
    }
    @Test
    public void gbkTest2() throws UnsupportedEncodingException {
        //正确的方式
        String name="验证码【577521】，打死不要告诉别人哦";
        byte[] gbkBytes=name.getBytes("GBK");
        System.out.println(new String(gbkBytes,"GBK"));
        byte[] utfBytes=name.getBytes("UTF-8");
        System.out.println(new String(utfBytes,"UTF-8"));
    }

    @Test
    public void stringfilterTest2(){
      List<String> strings = Data.stringList();
        List<String> green = strings.stream().filter(s -> !s.equals("green")).collect(Collectors.toList());
        log.info("得到的数据：{}",green);
    }
    @Test
    public void filterTest3(){
        List<Phone> phoneList = Data.phoneList();
        //筛选出条件为....的数据
        List<Phone> colors  = phoneList.stream().filter(apple-> !apple.getColor().equals("red") && !apple.getColor().equals("black")).collect(Collectors.toList());
        //筛选出条件为....的数据
       // List<Phone> greenList  = phoneList.stream().filter(apple -> apple.getColor().equals("green")).collect(Collectors.toList());



        log.info("获取的颜色：{}",colors);

      /*  List<String> strings = phoneList.stream().map(Phone::getColor).collect(Collectors.toList());
        log.info("获取的颜色：{}",strings);
        List<String> colors = strings.stream().filter(s-> !s.equals("red") && !s.equals("green")).collect(Collectors.toList());
        log.info("获取的颜色：{}",colors);*/
    }

    @Test
    public void booleanTest(){
        boolean flag = true;
        log.info("得到的结果：{}",flag?0:1);
    }

    @Test
    public void returnTest(){
        List<Phone> phoneList = Data.phoneList();

        for (Phone phone:phoneList) {
            if (phone.getColor().equals("red")){
                log.info("red log");
                break;
            }
            log.info("打印吗？");
        }

       /* phoneList.forEach(phone -> {
          if (phoneList.size() == 5){
                log.info("Log red");
                return;
            }
            log.info("打印吗");

        });*/


        //Map<String, List<Phone>> collect = phoneList.stream().collect(Collectors.groupingBy(Phone::getColor));

        /*collect.forEach((k,v)->{
            if (k.equals("red")){
                log.info("得到的K:{}",k);
                return;
            }
            log.info("跳出循环吗？？？");
        });*/
    }




}
