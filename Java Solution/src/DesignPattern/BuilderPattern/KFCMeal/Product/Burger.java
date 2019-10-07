package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 10:55
 **/
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new WrapperPacking();
    }
}
