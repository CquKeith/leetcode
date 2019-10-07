package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 10:56
 * 饮料瓶装
 **/
public class BottlePacking implements Packing{
    @Override
    public String pack() {
        return "BottlePacking";
    }
}
