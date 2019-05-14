package com.tazine.third.berkeleydb;

import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

import java.io.File;

/**
 * BerkeleyDatabase
 *
 * @author frank
 * @date 2019/05/14
 */
public class BerkeleyDatabase {

    public static void main(String[] args) {
        EnvironmentConfig envCfg = new EnvironmentConfig();
//当数据库环境不存在的时候，创建一个数据库环境，默认为false.
        envCfg.setAllowCreate(true);
//以只读方式打开，默认为false.
        envCfg.setReadOnly(false);
//事务支持，默认为false.
        envCfg.setTransactional(true);

//        Environment mydbEnv = new Environment(new File(envHome), envCfg);
//
//        System.out.println("Env Config: " + mydbEnv.getConfig());


    }

}
