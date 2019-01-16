package com.tazine.design.flyweight;

/**
 * FlyWeightPatternDemo
 *
 * @author frank
 * @date 2019/1/13
 */
public class FlyWeightPatternDemo {

    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {

        // 使用工厂，通过传递颜色信息来获取实体类的对象
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
        // 可以看到，虽然需要20个对象来完成业务逻辑，但实际内存中只生成了5个
    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
