package JavaConcurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Keith
 * @date 2019-09-16 23:02
 **/
public class WaitNotifyTest {

    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }
    public synchronized void after(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newCachedThreadPool();
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();

        executorService.execute(waitNotifyTest::after);
        executorService.execute(waitNotifyTest::before);

    }

}
