package com.tazine.design.template;

/**
 * 抽象基类：定义算法骨架
 *
 * @author frank
 * @since 1.0.0
 */
public abstract class BidProcessor {

    public final void processBid() {

        // 第一步，将媒体的请求转换为系统可以处理的 DTO 对象
        convert2Dto();

        // 第二步，根据 Dto 对象在系统内进行广告检索
        processDto();

        // 第三部，将结果转为各个媒体对应的 response 返回
        bidResponse();
    }

    protected abstract void convert2Dto();

    private void processDto() {
        System.out.println("正在为您进行广告检索......");
    }

    protected abstract void bidResponse();
}
