package DesignPattern.AbstractFactoryPattern.Factory;

import DesignPattern.AbstractFactoryPattern.Product.*;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 **/
public class DellFactory extends AbstractFactory {
    @Override
    public MouseProduct createMouseProduct() {
        return new DellMouseProduct();
    }

    @Override
    public KeyboardProduct createKeyboardProduct() {
        return new DellKeyboardProduct();
    }

    @Override
    public MicProduct createMicProduct() {
        return new DellMicProduct();
    }
}
