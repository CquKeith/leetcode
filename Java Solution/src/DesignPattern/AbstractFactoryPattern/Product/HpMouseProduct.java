package DesignPattern.AbstractFactoryPattern.Product;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 **/
public class HpMouseProduct extends MouseProduct {
    @Override
    public void sayHi() {
        System.out.println("Hp mouse say hi~");
    }
}
