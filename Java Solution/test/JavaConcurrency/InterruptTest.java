package JavaConcurrency;

/**
 * @author chenmengliang
 * @date 2019/9/18 09:38
 **/
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 mythread2 = new MyThread2();
        mythread2.start();

        mythread2.interrupt();
        System.out.println("Run in Main");
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                sleep(10000);
                //被interrupt 下面不会输出 会马上抛出一场
                System.out.println("MyThread1 run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    private static class MyThread2 extends Thread{
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted()){
                System.out.println("Mythread 2 run:"+(++i));
            }
        }
    }

}


