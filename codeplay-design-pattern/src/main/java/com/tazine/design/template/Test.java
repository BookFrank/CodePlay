package com.tazine.design.template;

/**
 * 模板方法测试类
 *
 * @author frank
 * @date 2018/01/15
 */
public class Test {

    public static void main(String[] args) {

        BidProcessor processor = new TxBidProcessor();
        processor.processBid();

        System.out.println();
        BidProcessor processor1 = new AliBidProcessor();
        processor1.processBid();
    }
}
