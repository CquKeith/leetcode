package DesignPattern.NullObjectPattern;

/**
 * @author chenmengliang
 * @date 2019/10/9 20:00
 **/
public class Client {
    public static void main(String[] args) {

        System.out.println(CustomerFactory.getCustomer("tom").getName());
        System.out.println(CustomerFactory.getCustomer("jerry").getName());
        System.out.println(CustomerFactory.getCustomer("11").getName());
        System.out.println(CustomerFactory.getCustomer("toy").getName());

    }
}
