package com.tazine.codeplay.version.java8.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Spliterator;

/**
 * Jdk8NioFileIO
 *
 * @author frank
 * @date 2018/12/09
 */
public class Jdk8NioFileIO {

    public static void main(String[] args) {

        try {

            Path path = Paths.get("/Users/jiaer.ly/Desktop/test.txt");

            System.out.println(path.toString());

            System.out.println(path.getFileSystem());

            List<String> lines = Files.readAllLines(path);

            lines.forEach(line -> {
                System.out.println(line);
            });


            //以当前路径作为Path对象
            Path p = Paths.get(".");
            //使用传入的字符串返回一个Path对象
            Path p2 = Paths.get("D","ReviewIO","URL");
            //对应的路径
            System.out.println("p对象的对应路径：" + p.toString());
            System.out.println("p2对象的对应路径：" + p2.toString());
            //路径数量是以路径名的数量作为标准
            System.out.println("p路径数量：" + p.getNameCount());
            System.out.println("p2路径数量：" + p2.getNameCount());
            //获取绝对路径
            System.out.println("p绝对路径：" + p.toAbsolutePath());
            System.out.println("p2绝对路径：" + p2.toAbsolutePath());
            //获取父路径
            System.out.println("p父路径："  + p.getParent());
            System.out.println("p2父路径：" + p2.getParent());
            //获取p2对象的文件名或者文件目录名
            System.out.println(p2.getFileName());
            //通过Path对象返回一个分隔符对象
            Spliterator<Path> split = p2.spliterator();


            // 完成文件复制
            Path source = Paths.get("F:","Java经典练习题.pdf");
            Path dest = Paths.get("F:","files.txt");
            File f = new File("F:\\ok.pdf");
            f.createNewFile();//如果f对象对应路径不存在就创建一个。
            System.out.println("source对象的文件路径：" + source);
            //复制文件
            Files.copy(source, new FileOutputStream(f));

            //Path source = Paths.get("F:","Java经典练习题.pdf");
            ///** 返回值为boolean的操作方法样例 */
            //System.out.println(Files.isHidden(source));//文件是否隐藏
            //System.out.println(Files.isExecutable(source));//文件是否可执行
            //System.out.println(Files.isWritable(source));//文件是否可写
            ////获取Paths对象对应的文件路径的文件储存
            //FileStore f  = Files.getFileStore(Paths.get("F:"));
            //FileStore e = Files.getFileStore(Paths.get("E:"));
            //System.out.println("F盘的总大小" + f.getTotalSpace());
            //System.out.println("F盘的可用大小" + f.getUsableSpace());
            //System.out.println("F盘的未分配空间" + f.getUnallocatedSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
