package DesignPattern.AbstractFactoryPattern.Product;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 **/
public class DellMouseProduct extends MouseProduct {
    @Override
    public void sayHi() {
        System.out.println("Dell mouse say hi~");
    }
}
