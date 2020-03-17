package lockTest;

/**
 * @author chenmengliang
 * @date 2019/11/6 14:45
 **/
public class Test {

    public volatile  static int i = 0;


    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();

        for (int i = 0; i < 4; i++) {

            new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    test.add();
                }
            }).start();

        }

        //Thread.sleep(2000);
        System.out.println("i="+i);

    }

    private void add() {
        i++;
    }
}
