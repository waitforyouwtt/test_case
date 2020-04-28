package com.example.demo.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

/**
 * @Author: luoxian
 * @Date: 2020/4/28 18:36
 * @Email: 15290810931@163.com
 */
public class SimpleBeanInfo2 {


    private String header1;



    private String header2;


    private String header3;

    private String header4;


    public String getHeader1() {
        return header1;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public String getHeader3() {
        return header3;
    }

    public void setHeader3(String header3) {
        this.header3 = header3;
    }

    public String getHeader4() {
        return header4;
    }

    public void setHeader4(String header4) {
        this.header4 = header4;
    }

    @Override
    public String toString() {
        return "SimpleBeanInfo2{" +
                "header1='" + header1 + '\'' +
                ", header2='" + header2 + '\'' +
                ", header3='" + header3 + '\'' +
                ", header4='" + header4 + '\'' +
                '}';
    }
}
