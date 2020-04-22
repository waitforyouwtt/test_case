package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.putong.Phone;
import com.example.demo.putong.Roles;
import com.example.demo.putong.UserInfo;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
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

import static com.example.demo.Data.phoneList;
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

    @Test
    public void compareListTest(){
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
    }

    @Test
    public void joiner(){
        List<Phone> phoneList  = phoneList();
        String join = Joiner.on(" ").join(phoneList.stream().map(Phone::getName).collect(Collectors.toList()));
        log.info("得到的内容：{}",join);

      /* List<Phone> phoneList  = phoneList();
       Map<String, List<Phone>> collect = phoneList.stream().collect(Collectors.groupingBy(Phone::getColor));
       log.info("得到的数据：{}", JSON.toJSON(collect));
       String code = createCode("577", collect.get("black"));
       log.info("得到的结果：{}",code);*/
    }

    private String createCode(String parentCode, List<Phone> categoryList) {
        if (CollectionUtils.isEmpty(categoryList)) {
            return parentCode + "01";
        }
        String max = parentCode + "01";
        for (Phone info : categoryList) {
            if (String.valueOf(info.getPrice()).compareTo(max) > 0) {
                max = String.valueOf(info.getPrice());
            }
        }
        if (max.endsWith("99")) {
           log.info("类别下的编码已经达到最大");
        }
        return (Integer.parseInt(max) + 1) + "";
    }

}
