package com.tazine.codeplay.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logback 测试
 *
 * @author frank
 * @date 2018/12/08
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.info("日志测试 - {}", "Hello World");
    }
}
