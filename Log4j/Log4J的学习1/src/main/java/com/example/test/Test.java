package com.example.test;


import org.apache.log4j.Logger;

public class Test {
    private static Logger logger = Logger.getLogger("Test.class");

    public static void main(String[] args) {
        logger.debug("This is a debug message!");
        logger.info("This is a info message");
        logger.error("This is a error message");
    }
}
