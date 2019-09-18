package JavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenmengliang
 * @date 2019/9/18 09:28
 **/
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            //execute会自动新建一个MyRunnable对象，并调用start
            executorService.execute(new MyRunnable(i));
        }
        executorService.shutdown();
    }
}
class MyRunnable implements Runnable {
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("MyRunnable run:"+id);
    }
}
