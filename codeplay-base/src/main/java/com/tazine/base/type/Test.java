package com.tazine.base.type;

/**
 * Test
 *
 * @author frank
 * @date 2017/12/20
 */
public class Test {

    public static void main(String[] args) {

        // 0 开头的数字为8进制
        int i = 012;
        //int j = 078; 编译错误
        int k = (int) 056L;
        System.out.println(i);
        System.out.println(k);

        String msg = "hello";
        Object o = msg;
        if (o instanceof String){
            System.out.println("o instanceof String： true" );
        }

        if (o.getClass() == String.class){
            System.out.println(o.getClass() == String.class);
        }

        AbstractPlayer nbaPlayer = new NbaPlayer();
        System.out.println(nbaPlayer instanceof NbaPlayer);
        System.out.println(nbaPlayer instanceof AbstractPlayer);
    }
}
