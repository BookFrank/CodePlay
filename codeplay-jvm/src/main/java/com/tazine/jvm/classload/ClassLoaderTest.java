package com.tazine.jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test
 *
 * @author frank
 * @date 2017/12/12
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                //System.out.println(fileName);
                try {
                    InputStream is = getClass().getResourceAsStream(fileName);
                    byte[] b = new byte[is.available()];
                    is.read(b, 0, is.available());
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj = loader.loadClass("com.tazine.jvm.classload.ClassLoaderTest").newInstance();
//        Object obj1 = new ClassLoaderTest();

        System.out.println("obj " + obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
//        System.out.println("obj1 " + obj1.getClass());
//        System.out.println(obj1 instanceof ClassLoaderTest);
    }

}
