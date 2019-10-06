package DesignPattern.FactoryMethodPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:52
 **/
public class Client {
    public static void main(String[] args) {

        // 在ConcreteFactory1中 指定了
        // factoryMethod 用什么类实例化displayFactoryProduct中的Product
        Factory factory1 = new ConcreteFactory1();
        // 通过ConcreteFactory1中的factoryMethod方法 实例化product，并对product操作
        factory1.displayFactoryProduct();

        // 工厂方法实例化Product
        // Product中有type，但是未实例化；同时有displayProductType统一的方法（也即是已实现方法体）
        // type在ConcreteProduct2的构造方法中实例化
        // product2实例，
        Product product2 = new ConcreteProduct2();
        product2.displayProductType();

    }
}
