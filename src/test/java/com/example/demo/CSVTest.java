package com.example.demo;


import com.example.demo.csv.SimpleBeanInfo;
import com.example.demo.csv.SimpleBeanInfo2;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:51
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class CSVTest extends DemoApplicationTests{

    //old 按行读取
    @Test
    public void lineRead() throws IOException {
        File destFile = new File("E:/global/fenghuang.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/test.csv"),"gbk"));
        //逐行读取
        String[] strArr = null;
        while((strArr = reader.readNext())!=null){
            System.out.println(strArr[0]+"---"+strArr[1]+"----"+strArr[2]);
        }
        reader.close();
    }

    @Test
    public void indexNotAnnotionRead() throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/test.csv"), "gbk"));
        /*
         *基于列位置，映射成类
         */
        //csv文件中的第一列对应类的header，第二列对应类的header2，第三列对应类的header3
        String[] columnMapping = {"header1", "header2", "header3"};
        ColumnPositionMappingStrategy<SimpleBeanInfo> mapper = new ColumnPositionMappingStrategy<SimpleBeanInfo>();
        mapper.setColumnMapping(columnMapping);
        mapper.setType(SimpleBeanInfo.class);
        CsvToBean<SimpleBeanInfo> csvToBean = new CsvToBean<SimpleBeanInfo>();
        List<SimpleBeanInfo> list = csvToBean.parse(mapper, reader);
        for (SimpleBeanInfo e : list) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void  headerColumnNameMapping() throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/test.csv"),"gbk"));
        HeaderColumnNameMappingStrategy<SimpleBeanInfo> mapper = new
                HeaderColumnNameMappingStrategy<SimpleBeanInfo>();
        mapper.setType(SimpleBeanInfo.class);
        CsvToBean<SimpleBeanInfo>  csvToBean = new CsvToBean<SimpleBeanInfo>();

        List<SimpleBeanInfo> list = csvToBean.parse(mapper, reader);

        for(SimpleBeanInfo e : list){
            System.out.println(e);
        }
    }

    public void  headerColumnNameTranslate() throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/test.csv"),"gbk"));
        /*
         * 基于列名转换，映射成类
         */
        HeaderColumnNameTranslateMappingStrategy<SimpleBeanInfo2> mapper =
                new HeaderColumnNameTranslateMappingStrategy<SimpleBeanInfo2>();
        mapper.setType(SimpleBeanInfo2.class);

        Map<String,String> columnMapping = new HashMap<String,String>();
        columnMapping.put("header1", "header1");//csv中的header1对应bean的header1
        columnMapping.put("header2", "header2");
        columnMapping.put("header3", "header3");
        columnMapping.put("header4", "header4");
        mapper.setColumnMapping(columnMapping);

        CsvToBean<SimpleBeanInfo2>  csvToBean = new CsvToBean<SimpleBeanInfo2>();

        List<SimpleBeanInfo2> list = csvToBean.parse(mapper, reader);

        for(SimpleBeanInfo2 e : list){
            System.out.println(e);
        }
    }

}
