package DesignPattern.ChainOfResponsibilityPattern.LoggerExample;

/**
 * @author chenmengliang
 * @date 2019/10/7 13:24
 **/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    void write(String message) {
        System.out.println("Standard Console::Logger : "+message);
    }
}
