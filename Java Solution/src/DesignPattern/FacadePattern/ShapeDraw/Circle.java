package DesignPattern.FacadePattern.ShapeDraw;

/**
 * @author chenmengliang
 * @date 2019/10/10 11:25
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle()::draw");
    }
}
