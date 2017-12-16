package com.tazine.base;

/**
 * GOTO是java的保留字，现在没有使用，可以使用一下方式实现GOTO
 *
 * @author Frank
 * @since 1.0.0
 */
public class JavaGoTo {

    public static void main(String[] args) {
        goto1();
        goto2();
    }
    
    static void goto1() {
        L:
        for (int i = 0; i < 10; i++) {
            System.out.println("进入L第" + i + "次循环");
            Y:
            for (int k = 0; k < 10; k++) {
                if (i == 4 || i == 7) {
                    continue L;
                }
                System.out.println("当前" + i + k);
                if (i == 9 && k == 2) {
                    break L;
                }
            }
        }
    }

    static void goto2() {

        int arr[][] = {{1, 2, 3}, {4, 5, 6, 7}, {9}};
        boolean found = false;

        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(i + "-" + j);
                if (arr[i][j] == 6) {
                    found = true;
                    break;
                }
            }
        }

    }
}
