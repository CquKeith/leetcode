package DesignPattern.AdapterPattern.TurkeyQuack;

/**
 * @author chenmengliang
 * @date 2019/10/9 21:15
 **/
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble!");
    }
}
