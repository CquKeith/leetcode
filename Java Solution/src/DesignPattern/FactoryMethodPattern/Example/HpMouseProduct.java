package DesignPattern.FactoryMethodPattern.Example;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:17
 **/
public class HpMouseProduct extends MouseProduct{
    @Override
    void sayHi() {
        System.out.println("Hp Mouse Product Say Hi~");
    }
}
