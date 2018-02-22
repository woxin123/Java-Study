package com.example.fomatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {
    // 日期模版
    private String datePattern;
    // 日期格式化对象
    private SimpleDateFormat simpleDateFormat;

    public DateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.simpleDateFormat = new SimpleDateFormat(datePattern);
    }
    // 解析字符串返回一个Formatter<T>中的T对象
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return simpleDateFormat.parse(text);
    }

    // 显示Formatter<T>的T对象
    @Override
    public String print(Date date, Locale locale) {
        return simpleDateFormat.format(date);
    }
}
