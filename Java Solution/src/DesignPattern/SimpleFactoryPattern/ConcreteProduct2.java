package DesignPattern.SimpleFactoryPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:51
 **/
public class ConcreteProduct2 implements Product {

    private ProductTypeEnum type = ProductTypeEnum.TYPE2;


    @Override
    public void displayProduct() {
        System.out.println(type.toString());
    }
}
