package com.example.demo.controller;

import com.example.demo.csv.AliGlobalPayBillRowModel;
import com.example.demo.csv.CsvUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/4/28 17:27
 * @Email: 15290810931@163.com
 */
@Controller
@Slf4j
public class CsvController {

    @PostMapping("/csv")
    public Map<String, String> batchInsert(@RequestParam("file") MultipartFile file) {

        Map map = new HashMap();
        // 将csv文件内容转成bean
       /* List<AliGlobalPayBillRowModel> csvData = CsvUtil.getCsvData(file, AliGlobalPayBillRowModel.class);
        log.info("解析csv 的结果：{}",csvData);*/
        return map;
    }

}
