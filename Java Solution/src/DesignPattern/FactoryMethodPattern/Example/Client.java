package DesignPattern.FactoryMethodPattern.Example;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:11
 **/
public class Client {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new DellMouseFactory();

        mouseFactory.sayHi();
    }
}
