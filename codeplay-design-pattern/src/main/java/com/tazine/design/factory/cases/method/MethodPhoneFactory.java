package com.tazine.design.factory.cases.method;

import com.tazine.design.factory.cases.product.Phone;

/**
 * MethodPhoneFactory
 *
 * @author frank
 * @date 2018/1/28
 */
public interface MethodPhoneFactory {

    /**
     * 这里限定了生产的对象
     *
     * @return Phone
     */
    Phone makePhone();
}
