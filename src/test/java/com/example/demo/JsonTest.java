package com.example.demo;

import com.example.demo.csv.AliGlobalPayBillRowModel;
import com.example.demo.csv.CSVUtils;
import com.example.demo.csv.CsvUtil;
import com.example.demo.csv.SimpleBeanInfo;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.*;


/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class JsonTest extends DemoApplicationTests{

    @Test
    public void fastJson(){
        String hello = "  你好啊   ";
        log.info("str 去掉空格：{}",stringTrim(hello) );
    }

    private String  stringTrim(String str){
        str = str.trim();
        while (str.startsWith("　")) {//这里判断是不是全角空格
            str = str.substring(1, str.length()).trim();
        }
        while (str.endsWith("　")) {
            str = str.substring(0, str.length() - 1).trim();
        }
        return str;
    }

    @Test
    public void strings(){
        List <String> strings = Arrays.asList("苹果","橘子","葡萄");
        String goodsIdStr = String.join(",", strings);
        log.info("得到的结果：{}",goodsIdStr);
    }

    @Test
    public void json(){
        Map map = new HashMap();
        map.put("syncY","Y");
        map.put("success","true");
        System.out.println(map.toString());
    }



    @Test
    public void csvTest() throws Exception {
        CsvUtil csvUtil = new CsvUtil();
        File destFile = new File("E:/global/fenghuang.csv");
     /*   InputStream inputStream = file2InputStream(destFile);
        // 将csv文件内容转成bean
        List<AliGlobalPayBillRowModel> csvData = csvUtil.getCsvData(inputStream, AliGlobalPayBillRowModel.class);*/
       /* List list = csvUtil.parseCsvToBean(destFile, AliGlobalPayBillRowModel.class);
        log.info("解析csv 的结果：{}",list);*/
        List<AliGlobalPayBillRowModel> readCsv =  CSVUtils.readCsv("E:/global/fenghuang.csv");
        log.info("解析csv 的结果：{}",readCsv);
    }

    @Test
    public void mappingTest() throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/test.csv"),"gbk"));
        /*
         *基于列位置，映射成类
         */
        //csv文件中的第一列对应类的header，第二列对应类的header2，第三列对应类的header3
        String[] columnMapping={"header1","header2","header3"};
        ColumnPositionMappingStrategy<SimpleBeanInfo> mapper = new ColumnPositionMappingStrategy<SimpleBeanInfo>();
        mapper.setColumnMapping(columnMapping);
        mapper.setType(SimpleBeanInfo.class);

        CsvToBean<SimpleBeanInfo> csvToBean = new CsvToBean<SimpleBeanInfo>();

        List<SimpleBeanInfo> list = csvToBean.parse(mapper, reader);

        for(SimpleBeanInfo e : list){
            System.out.println(e);
        }

    }


    @Test
    public void bindingTest() throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/test.csv"),"utf-8"));

        /*
         *基于列位置，映射成类
         */
        //csv文件中的第一列对应类的header，第二列对应类的header2，第三列对应类的header3
        String[] columnMapping={"header1","header2","header3"};
        ColumnPositionMappingStrategy<SimpleBeanInfo> mapper = new ColumnPositionMappingStrategy<SimpleBeanInfo>();
        mapper.setColumnMapping(columnMapping);
        mapper.setType(SimpleBeanInfo.class);
        /* */
        CsvToBean<SimpleBeanInfo>  csvToBean = new CsvToBean<SimpleBeanInfo>();

        List<SimpleBeanInfo> list = csvToBean.parse(mapper, reader);

        for(SimpleBeanInfo e : list){
            System.out.println(e);
        }


    }

}
