package DesignPattern.AbstractFactoryPattern.Factory;

import DesignPattern.AbstractFactoryPattern.Product.*;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 **/
public class HpFactory extends AbstractFactory {
    @Override
    public MouseProduct createMouseProduct() {
        return new HpMouseProduct();
    }

    @Override
    public KeyboardProduct createKeyboardProduct() {
        return new HpKeyboardProduct();
    }

    @Override
    public MicProduct createMicProduct() {
        return new HpMicProduct();
    }
}
