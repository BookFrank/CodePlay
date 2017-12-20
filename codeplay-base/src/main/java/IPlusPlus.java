/**
 * 运算符问题
 *
 * @author frank
 * @since 1.0.0
 */
public class IPlusPlus {

    static {
        int x = 5; // 局部变量，对成员变量无影响。
    }

    private static int x, y;


    public static void main(String[] args) {
        x--;
        myMethod();
        System.out.println(x + y++ + x);

    }

    static void myMethod() {
        y = x++ + ++x;    // y = 0   x= 1
    }
}
