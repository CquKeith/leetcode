package DesignPattern.AbstractFactoryPattern.Product;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 **/
public class DellMicProduct extends MicProduct {
    @Override
    public void sayHi() {
        System.out.println("Dell mic say hi~");
    }
}
