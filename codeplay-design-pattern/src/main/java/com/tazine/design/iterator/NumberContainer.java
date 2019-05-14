package com.tazine.design.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * Number Container
 *
 * @author frank
 * @date 2018/01/19
 */
public class NumberContainer implements Container {

    private List<Integer> list = Arrays.asList(1, 2, 3, 4);

    @Override
    public Iterator getIterator() {
        return new NumIterator();
    }

    public class NumIterator implements Iterator<Integer> {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return list.get(index++);
            }
            return null;
        }
    }
}
