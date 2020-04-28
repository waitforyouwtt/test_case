package com.example.demo.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author: luoxian
 * @Date: 2020/4/28 17:10
 * @Email: 15290810931@163.com
 */
@Slf4j
public class CsvUtil {

    /**
     *
     * @param inputStream
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getCsvData(InputStream inputStream, Class<T> clazz) {
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(inputStream, "utf-8");
        } catch (Exception e) {
            log.error("csv解析错误");
        }

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }

    public static List parseCsvToBean(File file, Class clazz) throws Exception {
        FileInputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        HeaderColumnNameMappingStrategy strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);
        CsvToBean csvToBean = new CsvToBeanBuilder(isr)
                .withMappingStrategy(strategy).build();
        isr.close();
        is.close();
        return csvToBean.parse();
    }



}
