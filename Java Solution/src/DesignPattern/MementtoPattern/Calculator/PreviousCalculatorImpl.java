package DesignPattern.MementtoPattern.Calculator;

/**
 * @author chenmengliang
 * @date 2019/10/15 20:42
 **/
public class PreviousCalculatorImpl implements PreviousCalculatorToCaretaker,PreviousCalculatorToOriginator {
    private int firstNumber;
    private int secondNumber;

    public PreviousCalculatorImpl(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
}
