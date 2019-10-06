package DesignPattern.AbstractFactoryPattern.Product;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 * 华硕键盘
 **/
public class AsusKeyboardProduct extends KeyboardProduct {
    @Override
    public void sayHi() {
        System.out.println("Asus keyboard say hi~");
    }
}
