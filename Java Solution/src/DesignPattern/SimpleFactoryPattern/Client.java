package DesignPattern.SimpleFactoryPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:52
 **/
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        Product product1 = simpleFactory.createProductByType(ProductTypeEnum.TYPE1);
        product1.displayProduct();

        Product product2 = simpleFactory.createProductByType(ProductTypeEnum.TYPE2);
        product2.displayProduct();

        Product product3 = simpleFactory.createProductByType(null);
        product3.displayProduct();


    }
}
