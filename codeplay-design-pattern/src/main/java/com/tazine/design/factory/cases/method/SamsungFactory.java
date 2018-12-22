package com.tazine.design.factory.cases.method;

import com.tazine.design.factory.cases.product.NoteEight;
import com.tazine.design.factory.cases.product.Phone;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @date 2018/1/28
 */
public class SamsungFactory implements MethodPhoneFactory {
    @Override
    public Phone makePhone() {
        return new NoteEight();
    }
}
