package DesignPattern.AbstractFactoryPattern.Factory;

import DesignPattern.AbstractFactoryPattern.Product.*;

/**
 * @author chenmengliang
 * @date 2019/10/6 21:52
 * 华硕工厂
 **/
public class AsusFactory extends AbstractFactory {
    @Override
    public MouseProduct createMouseProduct() {
        return new AsusMouseProduct();
    }

    @Override
    public KeyboardProduct createKeyboardProduct() {
        return new AsusKeyboardProduct();
    }

    @Override
    public MicProduct createMicProduct() {
        return new AsusMicProduct();
    }
}
