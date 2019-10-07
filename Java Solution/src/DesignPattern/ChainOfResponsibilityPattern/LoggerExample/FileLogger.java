package DesignPattern.ChainOfResponsibilityPattern.LoggerExample;

/**
 * @author chenmengliang
 * @date 2019/10/7 13:24
 **/
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    void write(String message) {
        System.out.println("File::Logger : "+message);
    }
}
