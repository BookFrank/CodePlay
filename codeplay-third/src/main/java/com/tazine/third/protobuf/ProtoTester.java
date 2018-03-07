package com.tazine.third.protobuf;

import com.googlecode.protobuf.format.JsonFormat;

/**
 * @author jiaer.ly
 * @date 2018/02/26
 */
public class ProtoTester {

    public static void write() {
        PersonEntity.Person.Builder builder = PersonEntity.Person.newBuilder();
        builder.setId(1);
        builder.setName("jiaer");
        builder.setEmail("jiaer.ly@alibaba-inc.com");

        JsonFormat format = new JsonFormat();
        System.out.println(format.printToString(builder.build()));
    }

    public static void main(String[] args) {
        write();
    }

}
