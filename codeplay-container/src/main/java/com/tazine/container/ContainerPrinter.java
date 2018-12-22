package com.tazine.container;

import java.util.*;

/**
 * 容器内容打印
 *
 * @author Frank
 * @date 2018/1/11
 */
public class ContainerPrinter {

    /**
     * Collection 和 Map 的主要区别在于每个"槽"保存的元素个数，Collection在每个草只能保存一个元素，
     * Map 在每个槽内保存了两个对象，通过Entry<k, v>
     *
     * @param args
     */
    public static void main(String[] args) {
        print(fill(new ArrayList<>()));
        print(fill(new LinkedList<>()));
        print(fill(new HashSet<>()));
        print(fill(new TreeSet<>()));
        print(fill(new LinkedHashSet<>()));
        print(fill(new Hashtable<>()));
        print(fill(new HashMap<>()));
        print(fill(new TreeMap<>()));
        print(fill(new LinkedHashMap<>()));
    }

    static Collection<String> fill(Collection<String> c) {
        c.add("Apple");
        c.add("OPPO");
        c.add("HuaWei");
        c.add("XiaoMi");
        c.add("OPPO");
        return c;
    }

    static Map<String, String> fill(Map<String, String> m) {
        m.put("mi", "mix");
        m.put("oppo", "r9");
        m.put("mi", "mi6");
        m.put("apple", "iphone8");
        m.put("huawei", "mate10");
        m.put("apple", "iphonex");
        return m;
    }

    static void print(Collection<String> c) {
        System.out.println(c.getClass().getSimpleName() + " : " + c.toString());
    }

    static void print(Map<String, String> m) {
        System.out.println(m.getClass().getSimpleName() + " : " + m.toString());
    }

}
