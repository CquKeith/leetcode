package DesignPattern.StatePattern.ContextState;

/**
 * @author chenmengliang
 * @date 2019/10/16 12:24
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        context.start();

        context.start();

        context.stop();
        context.start();

        context.stop();


    }
}
