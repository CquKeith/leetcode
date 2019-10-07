package DesignPattern.PrototypePattern;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:09
 **/
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("draw in Rectangle");
    }
}
