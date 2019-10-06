package DesignPattern.FactoryMethodPattern.Example;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:13
 **/
public abstract class MouseFactory {
    abstract MouseProduct createMouseProduct();

    void sayHi(){
        MouseProduct mouseProduct = createMouseProduct();
        mouseProduct.sayHi();
    }
}
