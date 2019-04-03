package com.tazine.jvm.classload;

/**
 * MyClassLoader
 *
 * @author frank
 * @date 2017/12/12
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
