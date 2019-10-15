package DesignPattern.MementtoPattern.StateMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/10/15 21:06
 **/
public class CareTaker {
    private List<Memento> mementoList;

    public CareTaker() {
        mementoList = new ArrayList<>();
    }

    public void backup(Memento memento){
        mementoList.add(memento);
    }
    public Memento restore(int id){
        return mementoList.get(id);
    }
}
