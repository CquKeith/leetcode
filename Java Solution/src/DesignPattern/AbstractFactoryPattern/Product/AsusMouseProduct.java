package DesignPattern.AbstractFactoryPattern.Product;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 * 华硕鼠标
 **/
public class AsusMouseProduct extends MouseProduct {
    @Override
    public void sayHi() {
        System.out.println("Asus mouse say hi~");
    }
}
