package com.tazine.io.stream;

import java.io.*;

/**
 * Created by lina on 2017/12/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class MyInputStream extends FileInputStream {


    public void changeCase() throws IOException {
        while (available() > 0){
//            Character.isLowerCase();
        }
    }




    public MyInputStream(String name) throws FileNotFoundException {
        super(name);
    }

    public MyInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public MyInputStream(FileDescriptor fdObj) {
        super(fdObj);
    }
}
