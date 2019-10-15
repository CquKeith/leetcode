package DesignPattern.ObserverPattern.ScaleTransform;

/**
 * @author chenmengliang
 * @date 2019/10/15 23:08
 **/
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("HexObserver String:"+Integer.toHexString(subject.getState()));
    }
}
