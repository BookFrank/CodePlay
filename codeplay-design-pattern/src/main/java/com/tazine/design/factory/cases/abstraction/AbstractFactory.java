package com.tazine.design.factory.cases.abstraction;

import com.tazine.design.factory.cases.product.NoteBook;
import com.tazine.design.factory.cases.product.Phone;

/**
 * AbstractFactory
 *
 * @author frank
 * @date 2018/1/28
 */
public abstract class AbstractFactory {

    public abstract Phone makePhone(String name);

    public abstract NoteBook makeNoteBook(String name);
}
