package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.csv.AliGlobalPayBillRowModel;
import com.example.demo.entity.ThirdpartyBillResponseDto;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;


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
        buildThirdpartyBillResponseDto("E://2088731886301113_fptrade_20200518.csv");
    }

    public List<ThirdpartyBillResponseDto> buildThirdpartyBillResponseDto(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "gbk"));

        List<ThirdpartyBillResponseDto> list = new ArrayList<>();
        /*
         *基于列位置，映射成类
         */
        //csv文件中的第一列对应类的header，第二列对应类的header2，第三列对应类的header3
        String[] columnMapping = {"partnerTransactionId", "amount", "rmbAmount", "fee","settlement","rmbSettlement",
                "currency","rate","paymentTime","settlementTime","type","status","remarks","originalPartnerTransactionId"};

        ColumnPositionMappingStrategy<AliGlobalPayBillRowModel> mapper = new ColumnPositionMappingStrategy<AliGlobalPayBillRowModel>();
        mapper.setColumnMapping(columnMapping);
        mapper.setType(AliGlobalPayBillRowModel.class);
        CsvToBean<AliGlobalPayBillRowModel> csvToBean = new CsvToBean<AliGlobalPayBillRowModel>();
        List<AliGlobalPayBillRowModel> globalPayBillRowModelList = csvToBean.parse(mapper, reader);
        log.info("读取支付宝跨境购csv 表格内容：{}", JSON.toJSONString(globalPayBillRowModelList));

        for (int i = 0;i< globalPayBillRowModelList.size();i++) {
            AliGlobalPayBillRowModel row  = globalPayBillRowModelList.get(i+1);
            ThirdpartyBillResponseDto dto = new ThirdpartyBillResponseDto();
            dto.setServiceFee(new BigDecimal(row.getFee().replaceAll("\t","")));
            list.add(dto);
        }

        return list;
    }


    @Test
    public void read() throws IOException {
       String file = "E://2088731886301113_fptrade_20200518.csv";
        readCSV2(file);
    }

    public void readCSV2(String finalPath) {
        try {
            // 使用BOMInputStream自动去除UTF-8中的BOM
            Reader reader = new InputStreamReader(new FileInputStream(finalPath), "gbk");
            CSVReader csvReader = new CSVReader(reader, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);

            // 列名的映射
            HeaderColumnNameTranslateMappingStrategy<AliGlobalPayBillRowModel> strategy = new HeaderColumnNameTranslateMappingStrategy<AliGlobalPayBillRowModel>();
            strategy.setType(AliGlobalPayBillRowModel.class);

            Map<String, String> columnMapping = new HashMap<String, String>();
            columnMapping.put("Partner_transaction_id", "partnerTransactionId".replaceAll("\t",""));
            columnMapping.put("amount", "amount");
            columnMapping.put("Rmb_amount", "rmbAmount");
            columnMapping.put("fee", "fee");
            columnMapping.put("settlement", "settlement");
            columnMapping.put("Rmb_settlement", "rmbSettlement");
            columnMapping.put("currency", "currency");
            columnMapping.put("rate", "rate");
            columnMapping.put("Payment_time", "paymentTime");
            columnMapping.put("Settlement_time", "settlementTime");
            columnMapping.put("type", "type");
            columnMapping.put("status", "status");
            columnMapping.put("remarks", "remarks");
            columnMapping.put("Original_partner_transaction_ID", "originalPartnerTransactionId");

            strategy.setColumnMapping(columnMapping);

            CsvToBean<AliGlobalPayBillRowModel> csvToBean = new CsvToBean<AliGlobalPayBillRowModel>();

            List<AliGlobalPayBillRowModel> list = csvToBean.parse(strategy, csvReader);

            for (AliGlobalPayBillRowModel p : list) {
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




}
