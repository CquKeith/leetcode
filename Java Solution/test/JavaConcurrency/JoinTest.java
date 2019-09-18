package JavaConcurrency;

/**
 * @author chenmengliang
 * @date 2019/9/18 10:24
 * 在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
 *
 * 对于以下代码，虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，
 * b 线程会等待 a 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。
 **/
public class JoinTest {
    private class A extends Thread{
        @Override
        public void run() {

            System.out.println("A");
        }
    }

    private class B extends Thread{

        private A a;

        public B(A a){
            //这里的a一定是test（）中的a对象的引用
            //如果this.a = new A() 则run()中的a.join 就不是test()中的a对象，
            // 也就不会b先start，但是要等a执行完的情况了
            this.a = a;
        }

        @Override
        public void run() {
            try {
                //B次此时为阻塞，等待a执行完
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("B");
        }

    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();

    }

    public static void main(String[] args) {
        JoinTest joinTest = new JoinTest();
        joinTest.test();//A B
    }

}
