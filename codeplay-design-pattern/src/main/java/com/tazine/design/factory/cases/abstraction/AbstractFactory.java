package com.tazine.design.factory.cases.abstraction;

import com.tazine.design.factory.cases.product.NoteBook;
import com.tazine.design.factory.cases.product.Phone;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public abstract class AbstractFactory {

    public abstract Phone makePhone(String name);

    public abstract NoteBook makeNoteBook(String name);
}
