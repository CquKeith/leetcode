package DesignPattern.MementtoPattern.StateMemento;

/**
 * @author chenmengliang
 * @date 2019/10/15 21:04
 **/
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator("state #1");
        CareTaker careTaker = new CareTaker();

        originator.setState("state #2");

        careTaker.backup(originator.saveStateToMemento());
        originator.setState("state #3");
        careTaker.backup(originator.saveStateToMemento());

        originator.setState("state #4");

        System.out.println(originator.getState());

        originator.getStateFromMemento(careTaker.restore(0));
        System.out.println(originator.getState());

        originator.getStateFromMemento(careTaker.restore(1));
        System.out.println(originator.getState());


    }
}
