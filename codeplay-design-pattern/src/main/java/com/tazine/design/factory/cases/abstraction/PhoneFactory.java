package com.tazine.design.factory.cases.abstraction;

import com.tazine.design.factory.cases.product.IphoneX;
import com.tazine.design.factory.cases.product.NoteBook;
import com.tazine.design.factory.cases.product.NoteEight;
import com.tazine.design.factory.cases.product.Phone;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class PhoneFactory extends AbstractFactory {

    @Override
    public Phone makePhone(String name) {
        if ("iphonex".equalsIgnoreCase(name)){
            return new IphoneX();
        }else if ("note8".equalsIgnoreCase(name)){
            return new NoteEight();
        }
        return null;
    }

    @Override
    public NoteBook makeNoteBook(String name) {
        return null;
    }
}
