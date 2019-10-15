package DesignPattern.ObserverPattern.ScaleTransform;

/**
 * @author chenmengliang
 * @date 2019/10/15 23:07
 **/
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);

        subject.setState(10);
    }
}
