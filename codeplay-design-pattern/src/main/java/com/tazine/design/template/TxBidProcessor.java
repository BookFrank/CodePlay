package com.tazine.design.template;

/**
 * 子类实现延迟步骤
 *
 * @author frank
 * @since 1.0.0
 */
public class TxBidProcessor extends BidProcessor {
    @Override
    protected void convert2Dto() {
        System.out.println("将腾讯请求转为 DTO");
    }

    @Override
    protected void bidResponse() {
        System.out.println("返回腾讯的 Response");
    }
}
