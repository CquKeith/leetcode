package DesignPattern.AbstractFactoryPattern.Factory;

import DesignPattern.AbstractFactoryPattern.Product.KeyboardProduct;
import DesignPattern.AbstractFactoryPattern.Product.MicProduct;
import DesignPattern.AbstractFactoryPattern.Product.MouseProduct;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:47
 **/
public abstract class AbstractFactory {
    public abstract MouseProduct createMouseProduct();
    public abstract KeyboardProduct createKeyboardProduct();
    public abstract MicProduct createMicProduct();
}
