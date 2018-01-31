package com.tazine.container.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by lina on 2018/1/29.
 *
 * @author frank
 * @since 1.0.0
 */
public class Test<K,V> {

    private static class Node<K,V> implements Map.Entry<K,V>{
        int hash;
        K key;
        V value;
        Node<K,V> next;

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this){
                return true;
            }
            return false;
        }
    }

    static final int DEFAULT_CAPACITY = 16;

    static final float DEFAULT_LOADFACTOR = 0.75f;

    static final int TREE_LENGTH = 8;

    static final int LIST_LENGTH = 6;

    public Test() {
    }
}
