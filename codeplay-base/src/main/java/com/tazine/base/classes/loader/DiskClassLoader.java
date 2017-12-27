package com.tazine.base.classes.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * DiskClassLoader
 *
 * @author frank
 * @since 1.0.0
 */
public class DiskClassLoader extends ClassLoader {

    private String myClassPath;

    public DiskClassLoader(String myClassPath) {
        this.myClassPath = myClassPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String filePath = getFilePath(name);
        try {
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes,0,inputStream.available());
            inputStream.close();
            return defineClass(name,bytes,0,bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private String getFilePath(String fullName) {
        String s = myClassPath + "/" + fullName.replace('.','/') + ".class";
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        DiskClassLoader cl = new DiskClassLoader("/Users/lina/codeplay/happy/CodePlay/codeplay-base/target/classes");
        cl.getFilePath("com.tazine.base.classes.loader.LoaderTest");

        Class<LoaderTest> cls = (Class<LoaderTest>) cl.findClass("com.tazine.base.classes.loader.LoaderTest");

//        LoaderTest lt = cls.newInstance();

//        lt.test();
        for (Method method : cls.getDeclaredMethods()){
            System.out.println(method.getName());
            method.invoke(cls.newInstance());
        }

    }



}
