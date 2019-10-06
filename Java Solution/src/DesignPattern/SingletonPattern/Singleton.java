package DesignPattern.SingletonPattern;

/**
 * @author chenmengliang
 * @date 2019/10/6 14:27
 **/
public class Singleton {
    /**
     * volatile 禁止指令重排。
     * singleton = new Singleton();
     * 有三个步骤：
     *      1. 为singleton分配内存空间
     *      2. 初始化singleton
     *      3. 将singleton指向分配的内存
     *
     **/
    private static volatile Singleton singleton;

    private Singleton(){

    }


    /**
     * 双重校验锁 - 线程安全
     * @return
     */
    public static synchronized Singleton getUniqueInstanceDoubleCheck(){
        if (null == singleton){
            synchronized (Singleton.class){
                if (null == singleton){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 静态内部类的实现方法
     */
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getUniqueInstanceBySingletonHolder(){
        return SingletonHolder.INSTANCE;
    }
}
