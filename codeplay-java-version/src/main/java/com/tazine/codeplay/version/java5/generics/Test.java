package com.tazine.codeplay.version.java5.generics;

import com.tazine.codeplay.version.NbaPlayer;
import com.tazine.codeplay.version.Student;

/**
 * @author jiaer.ly
 * @date 2019/05/31
 */
public class Test {

    public static void main(String[] args) {

        //Cont<NbaPlayer, Student> cont1 = new Cont<>();

        SingleGeneric<NbaPlayer> singleGeneric = new SingleGenericImpl<>();

    }

}
