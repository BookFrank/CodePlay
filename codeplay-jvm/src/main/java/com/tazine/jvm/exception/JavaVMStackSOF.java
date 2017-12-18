package com.tazine.jvm.exception;

/**
 * VM Args: -Xss128k
 * 栈容量只由 -Xss 参数设定
 *
 * @author frank
 * @since 1.0.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF sof = new JavaVMStackSOF();

        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + sof.stackLength);
            throw e;
        }
    }

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    // java -Xss168k com.tazine.jvm.exception.JavaVMStackSOF

    // 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出 StackOverflowError 异常
    // 如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出 OutOfMemoryError 异常
}
