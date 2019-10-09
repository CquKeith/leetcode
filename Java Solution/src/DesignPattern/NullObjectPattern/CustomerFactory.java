package DesignPattern.NullObjectPattern;

/**
 * @author chenmengliang
 * @date 2019/10/9 20:08
 *
 * 通过该类获取Customer对象
 * 假设该类已经有了一些Customer对象
 *
 **/
public class CustomerFactory {

    private final static String[] names = {"Tom","Jerry"};


    public static AbstractCustomers getCustomer(String name){
        for (String item :
                names) {
            if (item.equalsIgnoreCase(name)) {
                return new RealCustomers(item);
            }
        }
        return new NullCustomer();
    }


}
