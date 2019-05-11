package com.tazine.design.iterator;

/**
 * 持有 Iterator 的具体容器
 *
 * @author frank
 * @date 2018/01/19
 */
public class NameContainer implements Container {

    public String[] names = {"kobe", "james", "iverson", "jordan"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    public class NameIterator implements Iterator<String>{

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            if (this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
