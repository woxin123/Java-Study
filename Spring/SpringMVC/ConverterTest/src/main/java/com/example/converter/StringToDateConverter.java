package com.example.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    private String dataPattern;

    public void setDataPattern(String dataPattern) {
        this.dataPattern = dataPattern;
    }

    public Date convert(String s) {
        try {
            SimpleDateFormat dataFormate = new SimpleDateFormat(this.dataPattern);
            return dataFormate.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("类型转换失败!");
            return null;
        }
    }

}
