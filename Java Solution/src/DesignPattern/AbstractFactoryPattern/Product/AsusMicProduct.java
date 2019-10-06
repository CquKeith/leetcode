package DesignPattern.AbstractFactoryPattern.Product;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 * 华硕麦克
 **/
public class AsusMicProduct extends MicProduct {
    @Override
    public void sayHi() {
        System.out.println("Asus mic say hi~");
    }
}
