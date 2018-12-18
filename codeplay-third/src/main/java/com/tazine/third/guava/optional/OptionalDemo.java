package com.tazine.third.guava.optional;

import com.google.common.base.Optional;

/**
 * Guava Optional<T>
 *
 * @author frank
 * @date 2017/08/09
 */
public class OptionalDemo {

    public static void main(String[] args) {

        Optional<Integer> val = Optional.of(5);
        System.out.println("Optional<Integer> val = Optional.of(5)");
        System.out.println("val.isPresent() = " + val.isPresent());
        System.out.println("val.orNull() = " + val.orNull());
        System.out.println("val.get() = " + val.get());
        System.out.println();

        val = Optional.fromNullable(null);
        System.out.println("val = Optional.fromNullable(null)");
        System.out.println("val.isPresent() = " + val.isPresent());
        System.out.println("val.orNull() = " + val.orNull());
        /**
         * 如果 Optional 为 Null 将触发异常，无法向下执行
         */
        // System.out.println("val.get() = " + val.get());
        System.out.println();
        val = Optional.of(5);

        // 创建引用缺失的 Optional 实例
        val = Optional.absent();
        System.out.println("val = Optional.absent()");
        System.out.println("val.isPresent() = " + val.isPresent());
        System.out.println("val.orNull() = " + val.orNull());
        System.out.println();

        // Optional 使用方式
        Optional<Integer> op = Optional.fromNullable(null);
        int a = op.or(21);
        System.out.println(a);
    }
}
