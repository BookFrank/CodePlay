package com.tazine.design.cor.handler;

/**
 * Manager handler
 *
 * @author Frank
 * @since 1.0.0
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
