package DesignPattern.StrategyPattern.MathOperation;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:42
 **/
public class Client {
    public static void main(String[] args) {
        Strategy addStrategy = new AddOperation();
        Strategy minusStrategy = new MinusOperation();
        Strategy multiplyStrategy = new MultiplyOperation();


        Context context = new Context(addStrategy);

        System.out.println(context.executeStrategy(1,2));

        context.setStrategy(minusStrategy);
        System.out.println(context.executeStrategy(1,2));

        context.setStrategy(multiplyStrategy);
        System.out.println(context.executeStrategy(1,2));



    }
}
