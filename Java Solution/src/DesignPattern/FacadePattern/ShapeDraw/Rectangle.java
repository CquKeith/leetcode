package DesignPattern.FacadePattern.ShapeDraw;

/**
 * @author chenmengliang
 * @date 2019/10/10 11:25
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle()::draw");
    }
}
