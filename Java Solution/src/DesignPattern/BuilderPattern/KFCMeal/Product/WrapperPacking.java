package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 10:56
 * 包装袋包装
 **/
public class WrapperPacking implements Packing{
    @Override
    public String pack() {
        return "WrapperPacking";
    }
}
