package DesignPattern.FactoryMethodPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 18:44
 **/
public class ConcreteFactory1 extends Factory {
    @Override
    Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
