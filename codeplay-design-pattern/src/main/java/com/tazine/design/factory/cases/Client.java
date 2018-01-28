package com.tazine.design.factory.cases;

import com.tazine.design.factory.cases.abstraction.AbstractFactory;
import com.tazine.design.factory.cases.abstraction.NotebookFactory;
import com.tazine.design.factory.cases.abstraction.PhoneFactory;
import com.tazine.design.factory.cases.method.IphoneFactory;
import com.tazine.design.factory.cases.method.MethodPhoneFactory;
import com.tazine.design.factory.cases.method.SamsungFactory;
import com.tazine.design.factory.cases.product.IphoneX;
import com.tazine.design.factory.cases.product.MacBook;
import com.tazine.design.factory.cases.product.NoteEight;
import com.tazine.design.factory.cases.product.ThinkPad;
import com.tazine.design.factory.cases.simple.SimplePhoneFactory;

/**
 * Client
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {


    public static void main(String[] args) {


        // 简单工厂模式：通过参数返回不同对象实例
        IphoneX x1 = (IphoneX) SimplePhoneFactory.makePhone("iphonex");
        NoteEight note8 = (NoteEight) SimplePhoneFactory.makePhone("note8");
        x1.call();
        note8.call();


        // 工厂方法模式：针对每个单独的产品提供一个工厂类，
        MethodPhoneFactory iphoneFactory = new IphoneFactory();
        MethodPhoneFactory samsungFactory = new SamsungFactory();
        IphoneX x2 = (IphoneX) iphoneFactory.makePhone();
        NoteEight n2 = (NoteEight) samsungFactory.makePhone();
        x2.call();
        n2.call();


        // 抽象工厂模式：
        AbstractFactory phoneFactory = new PhoneFactory();
        IphoneX x3 = (IphoneX) phoneFactory.makePhone("iphonex");
        NoteEight n3 = (NoteEight) phoneFactory.makePhone("note8");
        x3.call();
        n3.call();

        AbstractFactory noteFactory = new NotebookFactory();
        MacBook mac = (MacBook) noteFactory.makeNoteBook("macbook");
        ThinkPad pad = (ThinkPad) noteFactory.makeNoteBook("thinkpad");
        mac.surf();
        pad.surf();





    }



}
