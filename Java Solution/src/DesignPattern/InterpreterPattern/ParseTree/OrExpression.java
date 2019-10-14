package DesignPattern.InterpreterPattern.ParseTree;

/**
 * @author chenmengliang
 * @date 2019/10/14 17:20
 **/
public class OrExpression extends Expression {
    private Expression expression1 = null;
    private Expression expression2 = null;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    boolean interpret(String str) {
        return expression1.interpret(str) || expression2.interpret(str);
    }
}
