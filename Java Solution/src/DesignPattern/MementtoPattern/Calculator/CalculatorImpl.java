package DesignPattern.MementtoPattern.Calculator;

/**
 * @author chenmengliang
 * @date 2019/10/15 20:25
 **/
public class CalculatorImpl implements Calculator {

    private int firstNumber;
    private int secondNumber;

    /**
     * 备份本次计算的两个数
     * @return
     */
    @Override
    public PreviousCalculatorToCaretaker backupLastCalculation() {
        return new PreviousCalculatorImpl(firstNumber,secondNumber);
    }

    /**
     * 恢复备忘录至现在，也即是撤销了上次的错误操作
     * @return
     */
    @Override
    public void restoreLastCalculation(PreviousCalculatorToCaretaker memento) {
        this.firstNumber = ((PreviousCalculatorToOriginator)memento).getFirstNumber();
        this.secondNumber = ((PreviousCalculatorToOriginator)memento).getSecondNumber();
    }

    @Override
    public int getCalculationResult() {
        return firstNumber + secondNumber;
    }

    @Override
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}
