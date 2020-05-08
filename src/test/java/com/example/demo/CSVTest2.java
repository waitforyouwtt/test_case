package com.example.demo;


import com.alibaba.fastjson.JSON;
import com.example.demo.csv.AliGlobalPayBillRowModel;
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
public class CSVTest2 extends DemoApplicationTests{

    @Test
    public void indexNotAnnotionRead() throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("E:/global/fenghuang.csv"), "gbk"));
        /*
         *基于列位置，映射成类
         */
        //csv文件中的第一列对应类的header，第二列对应类的header2，第三列对应类的header3
        String[] columnMapping = {
                "partnerTransactionId",
                "transactionId",
                "amount",
                   "rmbAmount",
                  "fee",
                   "distributeAmount",
                   "distributeRmbAmount",
                   "settlement",
                   "rmbSettlement",
                   "currency",
                   "rate",
                   "paymentTime",
                   "settlementTime",
                   "type",
                   "status",
                   "remarks",
                   "code",
                   "originalPartnerTransactionId"

        };
        ColumnPositionMappingStrategy<AliGlobalPayBillRowModel> mapper = new ColumnPositionMappingStrategy<AliGlobalPayBillRowModel>();
        mapper.setColumnMapping(columnMapping);
        mapper.setType(AliGlobalPayBillRowModel.class);
        CsvToBean<AliGlobalPayBillRowModel> csvToBean = new CsvToBean<AliGlobalPayBillRowModel>();
        List<AliGlobalPayBillRowModel> globalPayBillRowModelList = csvToBean.parse(mapper, reader);
        log.info("读取支付宝跨境购csv 表格内容：{}", JSON.toJSONString(globalPayBillRowModelList));
    }


}
