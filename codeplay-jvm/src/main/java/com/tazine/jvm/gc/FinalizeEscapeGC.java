package com.tazine.jvm.gc;

/**
 * 因为在GC时会执行对象的finalize方法，可以用来自救
 * 1. 对象在被GC时可以自我拯救
 * 2. 这种自救的机会只有一次，因为finalize方法最多只会被系统调用一次
 *
 * @author frank
 * @since 1.0.0
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, i am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead");
        }
    }
}
