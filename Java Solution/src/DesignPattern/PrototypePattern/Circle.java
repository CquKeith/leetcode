package DesignPattern.PrototypePattern;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:09
 **/
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("draw in Circle");
    }
}
