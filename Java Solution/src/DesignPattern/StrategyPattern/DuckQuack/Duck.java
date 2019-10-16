package DesignPattern.StrategyPattern.DuckQuack;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:32
 **/
public class Duck {
    private QuackBehavior quackBehavior;


    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(){
        if (null != quackBehavior){
            quackBehavior.quack();
        }
    }

}
