package com.example.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditer extends PropertyEditorSupport {
    // 将传入的字符串转化为Date

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(text);
            setValue(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
