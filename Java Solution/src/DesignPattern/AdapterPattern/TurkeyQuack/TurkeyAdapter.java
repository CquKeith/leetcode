package DesignPattern.AdapterPattern.TurkeyQuack;

/**
 * @author chenmengliang
 * @date 2019/10/9 21:16
 **/
public class TurkeyAdapter implements Duck {

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
