package DesignPattern.ObserverPattern.ScaleTransform;

/**
 * @author chenmengliang
 * @date 2019/10/15 23:08
 **/
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);

    }

    @Override
    void update() {
        System.out.println("OctalObserver String:"+Integer.toOctalString(subject.getState()));
    }
}
