package com.tazine.codeplay.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author frank
 * @date 2019/01/21
 */
public class CDate {

    public static void main(String[] args) throws ParseException {

        // Java 代码中可以识别24点的信息，就算写成24点，打印出的结果是下一天00点
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = sdf.parse("2019-01-20 24:00:00");
        System.out.println(startTime);
    }
}
