package com.tazine.container.collection.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lina on 2018/1/11.
 *
 * @author frank
 * @since 1.0.0
 */
public class SetOperations {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        Collections.addAll(set, "A B C D E".split(" "));

    }

}
