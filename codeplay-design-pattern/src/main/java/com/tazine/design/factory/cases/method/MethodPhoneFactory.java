package com.tazine.design.factory.cases.method;

import com.tazine.design.factory.cases.product.Phone;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public interface MethodPhoneFactory {
    /**
     * 这里限定了生产的对象
     * @return
     */
    Phone makePhone();
}
