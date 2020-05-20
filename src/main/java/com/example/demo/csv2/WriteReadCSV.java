package com.example.demo.csv2;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.io.input.BOMInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 17:05
 * @Email: 15290810931@163.com
 */
public class WriteReadCSV {

    public void writeCSV2(List<Person> dataList, String finalPath) {
        try {
            Writer writer = new FileWriter(finalPath);
            // 手动加上BOM标识
            writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }));

            // 设置显示的顺序
            String[] columnMapping = { "name", "age", "sex", "phone", "address" };
            ColumnPositionMappingStrategy<Person> mapper =
                    new ColumnPositionMappingStrategy<Person>();
            mapper.setType(Person.class);
            mapper.setColumnMapping(columnMapping);

            // 写表头
            CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER);
            String[] header = { "姓名", "年龄", "性别", "手机", "住址" };
            csvWriter.writeNext(header);

            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(mapper)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withEscapechar('\\').build();
            beanToCsv.write(dataList);
            csvWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
        System.out.println(finalPath + "数据导出成功");
    }

    public void readCSV2(String finalPath) {
        try {
            // 使用BOMInputStream自动去除UTF-8中的BOM
            Reader reader = new InputStreamReader(new BOMInputStream(new FileInputStream(finalPath)), "utf-8");
            CSVReader csvReader = new CSVReader(reader, CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER);

            // 列名的映射
            HeaderColumnNameTranslateMappingStrategy<Person> strategy =
                    new HeaderColumnNameTranslateMappingStrategy<Person>();
            strategy.setType(Person.class);
            Map<String, String> columnMapping = new HashMap<String, String>();
            columnMapping.put("姓名", "name");
            columnMapping.put("年龄", "age");
            columnMapping.put("性别", "sex");
            columnMapping.put("手机", "phone");
            columnMapping.put("住址", "address");
            strategy.setColumnMapping(columnMapping);

            CsvToBean<Person> csvToBean = new CsvToBean<Person>();

            List<Person> list = csvToBean.parse(strategy, csvReader);

            for (Person p : list) {
                System.out.println(p.toString());
            }
            csvReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Person> dataList = new ArrayList<Person>();

        Person person1 = new Person();
        person1.setName("張三");
        person1.setSex(1);
        person1.setAge(55);
        person1.setPhone("13911111111");
        person1.setAddress("北京海淀区");

        Person person2 = new Person();
        person2.setName("小美");
        person2.setSex(0);
        person2.setAge(20);
        person2.setPhone("13911112222");
        person2.setAddress("北京西城区");


        Person person3 = new Person();
        person3.setName("小明");
        person3.setSex(1);
        person3.setAge(25);
        person3.setPhone("13933333333");
        person3.setAddress("北京海淀区");

        dataList.add(person1);
        dataList.add(person2);
        dataList.add(person3);

        WriteReadCSV writer = new WriteReadCSV();
        String finalPath2 = "D:/bbb.csv";

      //  writer.writeCSV2(dataList, finalPath2);
        writer.readCSV2(finalPath2);

    }


}
