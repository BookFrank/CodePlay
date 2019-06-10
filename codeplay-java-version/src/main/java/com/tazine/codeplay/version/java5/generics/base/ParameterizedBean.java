package com.tazine.codeplay.version.java5.generics.base;

import java.util.List;
import java.util.Map;

/**
 * 列举一个实体类用代码解释是什么事参数化类型
 *
 * @author frank
 * @date 2018/06/10
 */
public class ParameterizedBean {

    private List<String> stringList;

    private List rawList;

    private Map<String, Long> stringMap;

    private Map rawMap;

    private Map.Entry<Long, Short> longEntry;
}
