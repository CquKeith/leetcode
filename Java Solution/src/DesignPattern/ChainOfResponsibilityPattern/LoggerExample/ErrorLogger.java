package DesignPattern.ChainOfResponsibilityPattern.LoggerExample;

/**
 * @author chenmengliang
 * @date 2019/10/7 13:24
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    void write(String message) {
        System.out.println("Error Console::Logger : "+message);
    }
}
