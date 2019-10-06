package DesignPattern.FactoryMethodPattern;

/**
 * @author chenmengliang
 * @date 2019/10/617:51
 * 这里 Product也是用了工厂方法
 **/
public abstract class Product {

    protected ProductTypeEnum type;

    void displayProductType(){
        System.out.println(type.toString());
    }
}
