package DesignPattern.FactoryMethodPattern.Example;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:13
 **/
public class HpMouseFactory extends MouseFactory {
    @Override
    MouseProduct createMouseProduct() {
        return new HpMouseProduct();
    }
}
