package com.tazine.design.cor.handler;

/**
 * Manager handler
 *
 * @author frank
 * @date 2017/12/27
 */
public class Manager extends PriceHandler {
    @Override
    public void processDiscountRequest(float discount) {
        if (discount <= 0.10) {
            System.out.println(this.getClass().getSimpleName() + " 批准了折扣：" + discount);
        } else {
            this.successor.processDiscountRequest(discount);
        }
    }
}
