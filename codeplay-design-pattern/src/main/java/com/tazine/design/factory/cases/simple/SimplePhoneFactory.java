package com.tazine.design.factory.cases.simple;

import com.tazine.design.factory.cases.product.IphoneX;
import com.tazine.design.factory.cases.product.NoteEight;
import com.tazine.design.factory.cases.product.Phone;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @date 2018/1/28
 */
public class SimplePhoneFactory {

    public static Phone makePhone(String name) {

        if ("iphonex".equalsIgnoreCase(name)) {
            return new IphoneX();
        } else if ("note8".equalsIgnoreCase(name)) {
            return new NoteEight();
        } else {
            return null;
        }
    }

}
