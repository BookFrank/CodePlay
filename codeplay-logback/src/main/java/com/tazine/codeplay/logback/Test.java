package com.tazine.codeplay.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
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

    Logger rootLogger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        // 打印 Logger 状态 print internal state
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);

        logger.info("日志测试  - {}", "Hello World");
    }
}
