package DesignPattern.FactoryMethodPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/6 17:47
 **/
public abstract class Factory {


    /**
     * 返回product实例
     * 但是交由子类执行factoryMethod 创建不同的Product
     * @return
     */
    abstract Product factoryMethod();

    void displayFactoryProduct(){
        Product product = factoryMethod();
        product.displayProductType();
    }

}
