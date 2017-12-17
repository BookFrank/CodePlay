package com.tazine.design.cor.handler;

/**
 * PriceHandler 工厂 - 单一职责
 *
 * @author Frank
 * @since 1.0.0
 */
public class PriceHandlerFactory {
    /**
     * 工厂方法创建请求
     *
     * @return
     */
    public static PriceHandler create() {
        PriceHandler sales = new Salesman();
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler ceo = new Ceo();

        sales.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(ceo);
        return sales;
    }
}
