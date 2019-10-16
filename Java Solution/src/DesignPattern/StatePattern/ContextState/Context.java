package DesignPattern.StatePattern.ContextState;

/**
 * @author chenmengliang
 * @date 2019/10/16 12:22
 **/
public class Context {

    private StopState stopState;
    private StartState startState;


    private State state;

    public Context() {
        startState = new StartState();
        stopState = new StopState();
        state = stopState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void stop(){
        state.stop(this);
    }

    public void start(){
        state.start(this);
    }

    public StopState getStopState() {
        return stopState;
    }

    public StartState getStartState() {
        return startState;
    }
}
