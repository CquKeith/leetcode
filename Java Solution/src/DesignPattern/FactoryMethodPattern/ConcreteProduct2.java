package DesignPattern.FactoryMethodPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:51
 **/
public class ConcreteProduct2 extends Product {

    public ConcreteProduct2() {
        // 实例化 继承来的 type
        type = ProductTypeEnum.TYPE2;
    }

}
