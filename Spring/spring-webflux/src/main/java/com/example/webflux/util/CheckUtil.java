package com.example.webflux.util;

import com.example.webflux.exception.CheckException;

import java.util.stream.Stream;

/**
 * @author mengchen
 * @time 18-8-24 下午9:01
 */
public class CheckUtil {

    private static final String[] INVAILD_NAMES = {"admin", "manager"};

    /**
     * 校验名字，不成功抛出异常
     * @param value
     */
    public static void checkName(String value) {
        Stream.of(INVAILD_NAMES).filter(name -> name.equalsIgnoreCase(value))
                .findAny().ifPresent(name -> {
                    throw new CheckException("name", "value");
        });
    }
}
