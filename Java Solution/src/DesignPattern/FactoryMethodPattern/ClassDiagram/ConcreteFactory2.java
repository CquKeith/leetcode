package DesignPattern.FactoryMethodPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/6 18:44
 **/
public class ConcreteFactory2 extends Factory {
    @Override
    Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
