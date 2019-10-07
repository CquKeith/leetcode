package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 11:00
 **/
public class Pepsi extends Drink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
