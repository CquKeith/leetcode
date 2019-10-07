package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 10:59
 **/
public abstract class Drink implements Item{
    @Override
    public Packing packing() {
        return new BottlePacking();
    }
}
