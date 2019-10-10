package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:19
 **/
public abstract class AbstractColleague {


    /**
     * 中介者传来消息时应该干嘛
     * @param mediator
     */
    abstract void onEvent(Mediator mediator);
}
