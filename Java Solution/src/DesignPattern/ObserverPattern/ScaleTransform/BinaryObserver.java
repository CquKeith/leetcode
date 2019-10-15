package DesignPattern.ObserverPattern.ScaleTransform;

/**
 * @author chenmengliang
 * @date 2019/10/15 23:08
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);

    }

    @Override
    void update() {
        System.out.println("Binary String:"+Integer.toBinaryString(subject.getState()));
    }
}
