package com.example.demo.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: luoxian
 * @Date: 2020/4/28 18:12
 * @Email: 15290810931@163.com
 */
public class CSVUtils {

    /**
     * 读取csv
     * @param <T>
     * @return
     */
    public static List<AliGlobalPayBillRowModel> readCsv(String fileName) throws FileNotFoundException, UnsupportedEncodingException {

        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName),"gbk"));

        HeaderColumnNameMappingStrategy<AliGlobalPayBillRowModel> mapper = new HeaderColumnNameMappingStrategy<AliGlobalPayBillRowModel>();
        mapper.setType(AliGlobalPayBillRowModel.class);
        CsvToBean<AliGlobalPayBillRowModel>  csvToBean = new CsvToBean<AliGlobalPayBillRowModel>();

        List<AliGlobalPayBillRowModel> list = csvToBean.parse();
        return list;
    }


}
