package DesignPattern.SimpleFactoryPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:47
 **/
public class SimpleFactory {

    public Product createProductByType(ProductTypeEnum typeEnum){
        if (ProductTypeEnum.TYPE1.equals(typeEnum)){
            return new ConcreteProduct1();
        }
        if (ProductTypeEnum.TYPE2.equals(typeEnum)){
            return new ConcreteProduct2();
        }
        throw new UnsupportedOperationException("类型不支持");
    }
}
