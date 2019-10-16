package DesignPattern.StatePattern.ContextState;

/**
 * @author chenmengliang
 * @date 2019/10/1612:21
 **/
public interface State {
    void start(Context context);
    void stop(Context context);
}
