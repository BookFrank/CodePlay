package com.tazine.third.protobuf.compare;

import com.alibaba.fastjson.JSON;
import com.googlecode.protobuf.format.JsonFormat;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author jiaer.ly
 * @date 2018/02/27
 */
public class ProtoWriteTest {

    private static final String FILE_PATH = "/Users/jiaer.ly/Documents/amap";

    public static void main(String[] args) {

//        AmapEntity.Traffic data = getObj();
//        JsonFormat format = new JsonFormat();
////        System.out.println(format.printToString(builder.build()));
//
//        try {
//            FileOutputStream fos = new FileOutputStream(FILE_PATH + "/amap.pb");
//            data.writeTo(fos);
//            fos.close();
//
//            InputStream is = new FileInputStream(FILE_PATH + "/amap.pb");
//            System.out.println(is.available());
//            AmapEntity.Traffic traffic = AmapEntity.Traffic.parseFrom(is);
//            System.out.println("---");
//            System.out.println(format.printToString(traffic));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        writeJson();

    }

    public static void writeJson(){
        String filePath = FILE_PATH + "/amap.json";
        FileOutputStream fos = null;

        try {
            InputStream is = new FileInputStream(FILE_PATH + "/amap.pb");
            System.out.println(is.available());
            AmapEntity.Traffic traffic = AmapEntity.Traffic.parseFrom(is);

            fos = new FileOutputStream(filePath);
            FileChannel channel = fos.getChannel();

            JsonFormat format = new JsonFormat();

            ByteBuffer bf = Charset.forName("utf-8").encode(format.printToString(traffic));
            System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());

            int length = 0;
            while ((length = channel.write(bf)) != 0) {
                System.out.println("写入长度" + length);
                System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeProto(){

    }

    public static AmapEntity.Traffic getObj(){
        AmapEntity.Traffic.Builder builder = AmapEntity.Traffic.newBuilder();

        builder.setEnt(2);
        builder.setDip(10880);
        builder.setDiu("864552030465178");
        builder.setSession("225836053");
        builder.setSign("809782A084B50D6C00D803A0CB8452CF");
        builder.setAetraffic(9);
        builder.setAppstartid("225836053");
        builder.setAdiu("26a6969f51113ilh9e77942f83e8db");
        builder.setCifa("800270040000000000000000010000000000000000000000000000000000000000000000000000000000000b000000060031312e302e3109006950686f6e65362c3205004150504c450a00382e312e322e32313237000000000000000000000000");
        builder.setDiu2("fffffffffffdffffffe8");
        builder.setDiv("ANDH080208");
        builder.setOutput("json");
        builder.setSiv("ANDH080208");
        builder.setDic("C02110001002");
        builder.setBIDF("M030000");
        builder.setStepid(85);
        builder.setDiu3("daa7fbbef8954559854a65a9da0e98ef-f05d56fd5b17b99e8fa63d3e1f534b2e");
        builder.setSpm("21157818446002312279898535228934292075060537");
        builder.setTid("WRrU46D4WZ0DAKaHF3D2XAii");
        builder.setUid(83134636);
        builder.setDibv(2128);
        builder.setChannel("amap7a");
        builder.setClientNetworkClass(3);
        builder.setCsid("24debff3-fe59-4a01-b032-b880290b65f1");
        builder.setAccs(1);
        builder.setGsid("aos-sns-proxy010184057191.et240eee0907b44ce373d4615e7d1041f17");

        return builder.build();
    }
}
