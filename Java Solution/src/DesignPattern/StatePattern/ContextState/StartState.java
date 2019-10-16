package DesignPattern.StatePattern.ContextState;

/**
 * @author chenmengliang
 * @date 2019/10/16 12:22
 **/
public class StartState implements State {


    @Override
    public void start(Context context) {
        System.out.println("already start");
    }

    @Override
    public void stop(Context context) {
        System.out.println("stop state");
        context.setState(context.getStopState());
    }
}
