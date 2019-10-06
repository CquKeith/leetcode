package DesignPattern.SimpleFactoryPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:51
 **/
public class ConcreteProduct1 implements Product {

    private ProductTypeEnum type = ProductTypeEnum.TYPE1;


    @Override
    public void displayProduct() {
        System.out.println(type.toString());
    }
}
