package DesignPattern.StatePattern.ContextState;

/**
 * @author chenmengliang
 * @date 2019/10/16 12:22
 **/
public class StopState implements State {

    @Override
    public void start(Context context) {
        System.out.println("start state");
        context.setState(context.getStartState());
    }

    @Override
    public void stop(Context context) {
        System.out.println("already stop");
    }
}
