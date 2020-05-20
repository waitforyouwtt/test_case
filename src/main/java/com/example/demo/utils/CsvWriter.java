package com.example.demo.utils;

import com.example.demo.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 16:45
 * @Email: 15290810931@163.com
 */
public class CsvWriter extends CsvFileWriter {

    private long userId;

    private String uuid;
    private String fileName;

    //外部调用，将UserId，uuid(随机数)，fileName传入
    public CsvWriter(long userId, String uuid, String fileName){
        this.userId = userId;
        this.uuid = uuid;
        this.fileName = fileName;
    }

    @Override
    List<String[]> getCsvContent() {

        List<String[]> allElements = new ArrayList<String[]>();
        //头文件
        String[] title = writeTitle();
        allElements.add(title);
        //文件内容
        UserInfo user = UserInfo.builder().account("15290810931@163.com").name("凤凰小哥哥")
                .telephone("15290810931").address("上海").sex("男").build();
        if (user != null) {
            String[] content = writeContent(user);
            allElements.add(content);
        }
        return allElements;
    }

    private String[] writeTitle() {
        String[] title = new String[]{"账户", "姓名", "电话", "地址", "性别"};
        return title;
    }


    private String[] writeContent(UserInfo user) {
        String[] content = new String[]{
                user.getAccount(),
                user.getName(),
                user.getTelephone(),
                user.getAddress(),
                user.getSex()
        };
        return content;
    }

    @Override
    String getCsvFileName() {
        return fileName;
    }

    @Override
    String getUuid() {
        return uuid;
    }

}
