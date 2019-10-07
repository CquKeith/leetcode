package DesignPattern.PrototypePattern;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:09
 **/
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("draw in Square");
    }
}
