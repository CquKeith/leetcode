package DesignPattern.ChainOfResponsibilityPattern.LoggerExample;

/**
 * @author chenmengliang
 * @date 2019/10/7 13:17
 *
 **/
public abstract class AbstractLogger {

    /**
     * Logger的三种级别
     */
    public static final int INFO  = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level,String message){

        if (this.level <= level){
            write(message);
            return;
        }

        if (null != nextLogger){
            nextLogger.logMessage(level,message );
        }

    }

    /**
     * 不同的ConcreteLogger 操作不同
     * @param message
     */
    abstract void write(String message);

}
