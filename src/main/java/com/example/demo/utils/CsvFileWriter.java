package com.example.demo.utils;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @Author: luoxian
 * @Date: 2020/5/20 16:42
 * @Email: 15290810931@163.com
 */

/**
 * 利用opencsv包中的CSVWriter类，生成csv文件
 * @param <T>
 */
public abstract class CsvFileWriter<T> {

    abstract List<String[]> getCsvContent();

    abstract String getCsvFileName();

    abstract String getUuid();

    public String execute() throws Exception {
        String result = "";
        String savePath = "D:/csv/" + "writer" + File.separator;

        try {
            //如果保存路径不存在，则自动创建
            File file = new File(savePath);
            if (!file.exists()) {
                file.mkdir();
            }
            String filePath = savePath + getUuid() + getCsvFileName();
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
            CSVWriter writer = new CSVWriter(out);

            writer.writeAll(getCsvContent());
            writer.close();
            result = filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
