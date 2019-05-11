package com.tazine.design.template;

/**
 * 子类实现延迟步骤
 *
 * @author frank
 * @date 2017/10/9
 */
public class AliBidProcessor extends BidProcessor {

    @Override
    protected void convert2Dto() {
        System.out.println("将阿里请求转为 DTO");
    }

    @Override
    protected void bidResponse() {
        System.out.println("返回阿里的 Response");
    }
}
