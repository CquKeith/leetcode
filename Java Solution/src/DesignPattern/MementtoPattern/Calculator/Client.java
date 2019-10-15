package DesignPattern.MementtoPattern.Calculator;

/**
 * @author chenmengliang
 * @date 2019/10/15 20:27
 **/
public class Client {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();

        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);

        // create memento
        PreviousCalculatorToCaretaker memento = calculator.backupLastCalculation();

        System.out.println(calculator.getCalculationResult());

        calculator.setFirstNumber(17);
        // user enters a wrong number and calculates result
        calculator.setSecondNumber(-290);
        System.out.println(calculator.getCalculationResult());

        // user hits CTRL+Z to undo last operation and see last result
        calculator.restoreLastCalculation(memento);

        System.out.println(calculator.getCalculationResult());



    }
}
