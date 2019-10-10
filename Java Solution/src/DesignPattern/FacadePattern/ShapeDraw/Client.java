package DesignPattern.FacadePattern.ShapeDraw;

/**
 * @author chenmengliang
 * @date 2019/10/10 11:26
 **/
public class Client {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

    }

}
