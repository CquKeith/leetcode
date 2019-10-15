package DesignPattern.MementtoPattern.Calculator;

/**
 * @author chenmengliang
 * @date 2019/10/15 20:24
 **/
public interface Calculator {

    // create memento
    PreviousCalculatorToCaretaker backupLastCalculation();

    // restore
    void restoreLastCalculation(PreviousCalculatorToCaretaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);
}
