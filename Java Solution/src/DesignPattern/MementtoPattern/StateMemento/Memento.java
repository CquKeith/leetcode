package DesignPattern.MementtoPattern.StateMemento;

/**
 * @author chenmengliang
 * @date 2019/10/15 21:06
 **/
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }


    public String getState() {
        return state;
    }
}
