package JavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenmengliang
 * @date 2019/9/18 10:01
 **/
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest e1 = new SynchronizedTest();
        SynchronizedTest e2 = new SynchronizedTest();

        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.execute(()->e1.fun1());
        executorService.execute(()->e2.fun1());

        //executorService.shutdown();

    }
    public void fun1(){
        synchronized (SynchronizedTest.class){
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
            }
        }
    }

}
