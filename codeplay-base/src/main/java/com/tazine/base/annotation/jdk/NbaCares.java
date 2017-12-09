package com.tazine.base.annotation.jdk;

/**
 * JDK中 @SuppressWarnings 注解用法
 *
 * @author Frank
 * @since 1.0.0
 */
public class NbaCares {

    @SuppressWarnings("deprecation")
    public void player() {
        Player kobe = new Kobe();
        kobe.care();
    }

}
