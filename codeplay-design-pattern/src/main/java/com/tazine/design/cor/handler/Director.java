package com.tazine.design.cor.handler;

/**
 * Director handler
 *
 * @author frank
 * @date 2017/12/27
 */
public class Director extends PriceHandler {
    @Override
    public void processDiscountRequest(float discount) {
        if (discount <= 0.20) {
            System.out.println(this.getClass().getSimpleName() + " 批准了折扣：" + discount);
        } else {
            this.successor.processDiscountRequest(discount);
        }
    }
}
