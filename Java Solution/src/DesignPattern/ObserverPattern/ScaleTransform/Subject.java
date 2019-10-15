package DesignPattern.ObserverPattern.ScaleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/10/15 23:04
 **/
public class Subject {
    private List<Observer> list = new ArrayList<>();

    // 十进制数值
    private int state;

    /**
     * 注册
     * @param observer
     */
    public void attach(Observer observer){
        list.add(observer);
    }
    
    public void notifyAllObservers(){
        for (Observer o :
                list) {
            o.update();
        }
    }
    
    

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
}
