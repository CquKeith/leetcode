package DesignPattern.InterpreterPattern.ParseTree;

/**
 * @author chenmengliang
 * @date 2019/10/14 17:18
 **/
public abstract class Expression {
    abstract boolean interpret(String str);
}
