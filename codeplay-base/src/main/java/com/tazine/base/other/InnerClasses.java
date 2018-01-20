package com.tazine.base.other;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 内部类
 *
 * @author frank
 * @since 1.0.0
 */
public class InnerClasses {

    // 静态内部类
    static class staticInnerClass {

    }

    // 内部类
    class innerClass {

    }

    // 局部内部类
    public void memberFunction() {
        class localInnerClass {

        }
    }
}

// 匿名内部类
class MyFrame extends Frame {
    public MyFrame() throws HeadlessException {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
}
