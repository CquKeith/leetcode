package JavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenmengliang
 * @date 2019/9/18 10:15
 **/
public class ReentrantLockTest {
    private ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ReentrantLockTest e1 = new ReentrantLockTest();

        executorService.execute(e1::fun);
        executorService.execute(e1::fun);

    }
    private void fun(){

        lock.lock();

        for (int i = 0; i < 100; i++) {
            System.out.print(i+" ");
        }
        System.out.println();

        lock.unlock();


    }
}
