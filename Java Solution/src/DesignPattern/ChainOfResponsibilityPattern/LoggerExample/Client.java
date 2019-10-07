package DesignPattern.ChainOfResponsibilityPattern.LoggerExample;

/**
 * @author chenmengliang
 * @date 2019/10/7 13:26
 **/
public class Client {
    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLogger();

        loggerChain.logMessage(AbstractLogger.INFO,"This is an information");
        loggerChain.logMessage(AbstractLogger.DEBUG,"This is a debug level information");
        loggerChain.logMessage(AbstractLogger.ERROR,"This is an error information");

    }

    /**
     * 获取到 责任链
     * @return
     */
    private static AbstractLogger getChainOfLogger(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;

    }

}
