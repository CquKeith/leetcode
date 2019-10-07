package DesignPattern.BuilderPattern.KFCMeal.Product;

/**
 * @author chenmengliang
 * @date 2019/10/7 10:51
 * 食物
 **/
public interface Item {
    /**
     * 获取食物的名称
     * @return
     */
    String name();

    /**
     * 打包食物 汉堡包装 饮料瓶装
     * @return
     */
    Packing packing();

    /**
     * 获取总价格
     * @return
     */
    float price();

}
