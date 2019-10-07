package DesignPattern.PrototypePattern;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:16
 **/
public class Client {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape cloneShape = ShapeCache.getShape("1");
        System.out.println("Shape: "+cloneShape.getType());

    }
}
