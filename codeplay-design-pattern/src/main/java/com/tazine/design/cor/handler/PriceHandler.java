package com.tazine.design.cor.handler;

/**
 * 对外暴露接口
 *
 * @author Frank
 * @since 1.0.0
 */
public abstract class PriceHandler {
    /**
     * 直接后继，用于传递请求
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 对外暴露接口：处理折扣申请
     *
     * @param discount
     */
    public abstract void processDiscountRequest(float discount);
}
