package DesignPattern.InterpreterPattern.ParseTree;

/**
 * @author chenmengliang
 * @date 2019/10/14 17:21
 **/
public class Client {


    /**
     * D And (A Or (B C))
     * @return
     */
    public static Expression buildExpression(){
        Expression terminal1 = new TerminalExpression("A");
        Expression terminal2 = new TerminalExpression("B");
        Expression terminal3 = new TerminalExpression("C");
        Expression terminal4 = new TerminalExpression("D");

        // B Or C
        Expression alternation1 = new OrExpression(terminal2,terminal3);
        // A or (B C)
        Expression alternation2 = new OrExpression(terminal1,alternation1);

        return new AndExpression(terminal4,alternation2);

    }

    public static void main(String[] args) {
        Expression define = buildExpression();
        String context1 = "D A";
        String context2 = "A B";
        System.out.println(define.interpret(context1));
        System.out.println(define.interpret(context2));
    }
}
