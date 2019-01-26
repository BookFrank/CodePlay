package com.tazine.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 自定义注解测试类
 *
 * @author frank
 * @date 2017/12/15
 */
public class Application {

    @Autowired
    private static Environment env;

    private int count;

    public static void main(String[] args) {
        Application app = new Application();
        parseAnnotations(app);
        System.out.println();
        System.out.println(env.getProperty("123"));
    }

    public static void parseAnnotations(Application application) {

        Class app = application.getClass();

        for (Field field : app.getDeclaredFields()) {
            System.out.print("当前字段名为" + field.getName() + " 类型为：" + field.getType());
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Autowired.class) {
                    try {
                        field.set("env", new Environment());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(" 注解为：" + annotation.annotationType().getName());
            }
            System.out.println();
        }
    }

}
