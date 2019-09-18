package JavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chenmengliang
 * @date 2019/9/18 09:46
 **/
public class ExecutorInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //单独提交的线程 可以单独interrupt
        Future<?> future = executorService.submit(()->{
            int i = 0;
            while (!Thread.interrupted())
                System.out.println("run in submit thread : "+(++i));
        });

        //通过cancel这种方式 interrupt单个线程
        future.cancel(true);


        for (int i = 0; i < 3; i++) {
            executorService.execute(()->{
                try {
                    Thread.sleep(200);
                    System.out.println("run in thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        Thread.sleep(10);


        //shutdownNow 相当于调用每个线程的interrupt
        executorService.shutdownNow();

    }
}
