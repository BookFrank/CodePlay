package com.tazine.third.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author jiaer.ly
 * @date 2019/05/23
 */
public class Test {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/Users/jiaer.ly/Desktop/pile_201904130104");
        byte[] bytes = Files.readAllBytes(path);

        PileSegmentData.HidPileLinkStatesList list =  PileSegmentData.HidPileLinkStatesList.parseFrom(bytes);
        list.getHidPileLinkStatesListList().stream().forEach(v -> {
            System.out.println(v.getHid());
        });


    }

}
