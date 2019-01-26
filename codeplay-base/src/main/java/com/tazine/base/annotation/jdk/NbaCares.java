package com.tazine.base.annotation.jdk;

/**
 * JDK中 @SuppressWarnings 注解用法
 *
 * @author frank
 * @date 2017/12/15
 */
public class NbaCares {

    @SuppressWarnings("deprecation")
    public void player() {
        Player kobe = new Kobe();
        kobe.care();
    }

}
