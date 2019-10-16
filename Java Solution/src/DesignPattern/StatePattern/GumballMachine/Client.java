package DesignPattern.StatePattern.GumballMachine;

/**
 * @author chenmengliang
 * @date 2019/10/16 10:53
 **/
public class Client {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        // 5个 -> 4个
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        // 4个 -> 4个
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        // 4个 -> 2个
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        System.out.println();

        // 2个 -> 0个
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        // sold out
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();



    }
}
