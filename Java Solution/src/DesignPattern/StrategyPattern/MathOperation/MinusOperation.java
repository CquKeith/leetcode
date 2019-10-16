package DesignPattern.StrategyPattern.MathOperation;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:40
 **/
public class MinusOperation implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
