package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 11:00
 **/
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
