package DesignPattern.StatePattern.GumballMachine;

/**
 * @author chenmengliang
 * @date 2019/10/16 10:34
 **/
public class SoldState implements  State{

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice does not get you another gumball!");
    }

    @Override
    public void dispense() {
        // 检查糖果是否还有，是否可以发放糖果
        gumballMachine.releaseBall();

        if (gumballMachine.getNumberGumballs() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
            System.out.println("succeed to sold one gumball,gumball left:"+gumballMachine.getNumberGumballs());
        }else {
            System.out.println("Oops, out of gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
