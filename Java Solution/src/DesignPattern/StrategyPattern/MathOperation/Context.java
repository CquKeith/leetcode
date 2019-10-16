package DesignPattern.StrategyPattern.MathOperation;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:41
 **/
public class Context {
    private Strategy strategy;


    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
