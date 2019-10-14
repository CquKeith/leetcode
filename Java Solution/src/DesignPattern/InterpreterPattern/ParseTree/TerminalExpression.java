package DesignPattern.InterpreterPattern.ParseTree;

import java.util.StringTokenizer;

/**
 * @author chenmengliang
 * @date 2019/10/14 17:19
 **/
public class TerminalExpression extends Expression {

    private String literal = null;

    public TerminalExpression(String literal) {
        this.literal = literal;
    }

    @Override
    boolean interpret(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()){
            String test = stringTokenizer.nextToken();
            if (test.equals(literal)){
                return true;
            }
        }
        return false;
    }
}
