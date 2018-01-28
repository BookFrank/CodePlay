package com.tazine.design.factory.cases.abstraction;

import com.tazine.design.factory.cases.product.MacBook;
import com.tazine.design.factory.cases.product.NoteBook;
import com.tazine.design.factory.cases.product.Phone;
import com.tazine.design.factory.cases.product.ThinkPad;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class NotebookFactory extends AbstractFactory {
    @Override
    public Phone makePhone(String name) {
        return null;
    }

    @Override
    public NoteBook makeNoteBook(String name) {
        if ("macbook".equalsIgnoreCase(name)){
            return new MacBook();
        }else if ("thinkpad".equalsIgnoreCase(name)){
            return new ThinkPad();
        }
        return null;
    }
}
