package com.tazine.jvm.loader;

/**
 * MyClassLoader
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
