package DesignPattern.StatePattern.GumballMachine;

/**
 * @author chenmengliang
 * @date 2019/10/1610:21
 **/
public interface State {
    /**
     * 投入25分钱
     */
    void insertQuarter();

    /**
     * 退回25钱
     */
    void ejectQuarter();

    /**
     * 转动手柄
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();
}
