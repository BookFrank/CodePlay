package com.tazine.third.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;

/**
 * ProtoTester
 *
 * @author frank
 * @date 2018/02/26
 */
public class ProtoTester {

    public static void write() throws InvalidProtocolBufferException {
        PersonEntity.Person.Builder builder = PersonEntity.Person.newBuilder();
        builder.setId(1);
        builder.setName("frank");
        builder.setEmail("frank@github.com");

        byte[] bs = builder.build().toByteString().toByteArray();
        PersonEntity.Person p2 = PersonEntity.Person.parseFrom(bs);
        System.out.println(p2.getEmail());

        JsonFormat format = new JsonFormat();
        System.out.println(format.printToString(builder.build()));
    }

    public static void main(String[] args) throws Exception {
        write();
    }
}
