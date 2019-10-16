package DesignPattern.StatePattern.GumballMachine;

/**
 * @author chenmengliang
 * @date 2019/10/16 10:37
 **/
public class GumballMachine {

    private NoQuarterState noQuarterState;
    private HasQuarterState hasQuarterState;
    private SoldOutState soldOutState;
    private SoldState soldState;

    // 贩卖机当前的状态
    private State state;

    // 贩卖机中糖果的数量
    private int numberGumballs;

    public GumballMachine(int numberGumballs) {
        this.numberGumballs = numberGumballs;

        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        if (numberGumballs <= 0){
            state = soldOutState;
        }else {
            state = noQuarterState;
        }

    }

    public void insertQuarter(){
        state.insertQuarter();
    }
    public void ejectQuarter(){
        state.ejectQuarter();
    }
    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }


    public void releaseBall(){
        System.out.println("A gumball comes rolling out of slot...");
        if (numberGumballs != 0){
            numberGumballs -= 1;
        }
    }


    public void setState(State state) {
        this.state = state;
    }

    public NoQuarterState getNoQuarterState() {
        return noQuarterState;
    }

    public HasQuarterState getHasQuarterState() {
        return hasQuarterState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public SoldState getSoldState() {
        return soldState;
    }


    public int getNumberGumballs() {
        return numberGumballs;
    }
}
