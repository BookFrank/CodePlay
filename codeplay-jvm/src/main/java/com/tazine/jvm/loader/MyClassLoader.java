package com.tazine.jvm.loader;

/**
 * Created by lina on 2017/12/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
