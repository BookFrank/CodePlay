package com.tazine.design.cor.handler;

/**
 * Salesman handler
 *
 * @author frank
 * @date 2017/12/27
 */
public class Salesman extends PriceHandler {

    @Override
    public void processDiscountRequest(float discount) {
        if (discount <= 0.05) {
            System.out.println(this.getClass().getSimpleName() + " 批准了折扣：" + discount);
        } else {
            this.successor.processDiscountRequest(discount);
        }
    }
}
