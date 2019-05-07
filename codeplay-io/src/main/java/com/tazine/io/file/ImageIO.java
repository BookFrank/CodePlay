package com.tazine.io.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * App
 *
 * @author frank
 * @date 2018/03/14
 */
public class ImageIO {

    public static void main(String[] args) {
        Path path = null;
        try {
            path = Paths.get("/Users/jiaer.ly/Desktop/book.png");
            byte[] data = Files.readAllBytes(path);
            byte[] encoded = Base64.getEncoder().encode(data);
            String imgDataAsBase64 = new String(encoded);
            String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
            System.out.println(imgAsBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
