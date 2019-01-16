package com.tazine.design.cor.handler;

/**
 * CEO handler
 *
 * @author frank
 * @date 2017/12/27
 */
public class Ceo extends PriceHandler {
    @Override
    public void processDiscountRequest(float discount) {
        if (discount <= 0.30) {
            System.out.println(this.getClass().getSimpleName() + " 批准了折扣：" + discount);
        } else {
            System.out.println(this.getClass().getSimpleName() + " 拒绝了折扣：" + discount);
        }
    }
}
