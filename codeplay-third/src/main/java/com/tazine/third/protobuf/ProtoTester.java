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
//        PersonEntity.Person p2 = PersonEntity.Person.parseFrom(bs);
        PersonDTO.Person p2 = PersonDTO.Person.parseFrom(bs);
        PersonDO.Person p3 = PersonDO.Person.parseFrom(bs);
        System.out.println(p2.getEmail());
        System.out.println(p3.getEmail());

        PersonDO.Person.Builder pb = PersonDO.Person.newBuilder();
        pb.setId(1);
        pb.setName("frank");
        pb.setEmail("frank@github.com");


        JsonFormat format = new JsonFormat();
        System.out.println(format.printToString(builder.build()));
        System.out.println(format.printToString(pb.build()));
    }

    public static void main(String[] args) throws Exception {
        write();
    }
}
