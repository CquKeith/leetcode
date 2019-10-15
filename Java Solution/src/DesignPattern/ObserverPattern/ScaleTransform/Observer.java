package DesignPattern.ObserverPattern.ScaleTransform;

/**
 * @author chenmengliang
 * @date 2019/10/15 23:04
 **/
public abstract class Observer {
    protected Subject subject;
    abstract void update();
}
