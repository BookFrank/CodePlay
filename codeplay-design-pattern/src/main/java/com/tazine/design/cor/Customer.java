package com.tazine.design.cor;

import com.tazine.design.cor.handler.PriceHandler;
import com.tazine.design.cor.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * 客户折扣请求
 *
 * @author frank
 * @date 2017/12/27
 */
public class Customer {

    // 只关注折扣被处理，而不在乎是被谁处理。

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.create());

        Random rand = new Random();
        // 发出一百次折扣申请
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " - ");
            customer.requestDiscount(rand.nextFloat());
        }
    }

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount) {
        this.priceHandler.processDiscountRequest(discount);
    }
}
