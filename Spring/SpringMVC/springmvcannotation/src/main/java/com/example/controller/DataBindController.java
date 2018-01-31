package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataBindController {
    private static final Logger logger = Logger.getLogger(DataBindController.class);
    // 测试PathVariable注解
    @RequestMapping("/pathVariableTest/{userId}")
    public void pathVariableTest(@PathVariable Integer userId) {
        logger.info("通过@PathVariableTest获取的数据：" + userId);
    }

    //测试@RequestHeader注解
    @RequestMapping("/requestHeaderTest")
    public void requestHeaderTest(@RequestHeader("User-Agent") String userAgent,
                                  @RequestHeader(value="Accept") String[] accepts) {
        logger.info("通过@RequestHeader获得数据：" + userAgent);
        for (String accept : accepts) {
            logger.info(accept);
        }
    }

    @RequestMapping("/cookieValueTest")
    public void cookieValueTest(@CookieValue(value = "JSESSIONID", defaultValue = "")
                                            String sessionID) {
        logger.info("通过@CookieValue的数据：" + sessionID);
    }

}
