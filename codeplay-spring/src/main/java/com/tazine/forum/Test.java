package com.tazine.forum;

import com.tazine.forum.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lina on 2017/10/9.
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);


        for (String a : ctx.getBeanDefinitionNames()){
            System.out.println(a);
        }

        ctx.getBean(UserDao.class).findUserByUserName("admin");

        ctx.getBean(UserDao.class).diTest();




    }

}
