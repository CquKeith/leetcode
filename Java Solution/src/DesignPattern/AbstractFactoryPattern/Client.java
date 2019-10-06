package DesignPattern.AbstractFactoryPattern;

import DesignPattern.AbstractFactoryPattern.Factory.AbstractFactory;
import DesignPattern.AbstractFactoryPattern.Factory.HpFactory;
import DesignPattern.AbstractFactoryPattern.Product.KeyboardProduct;
import DesignPattern.AbstractFactoryPattern.Product.MicProduct;
import DesignPattern.AbstractFactoryPattern.Product.MouseProduct;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:47
 **/
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new HpFactory();
        MouseProduct mouseProduct = factory.createMouseProduct();
        mouseProduct.sayHi();

        KeyboardProduct keyboardProduct = factory.createKeyboardProduct();
        keyboardProduct.sayHi();

        MicProduct micProduct = factory.createMicProduct();
        micProduct.sayHi();
    }
}
