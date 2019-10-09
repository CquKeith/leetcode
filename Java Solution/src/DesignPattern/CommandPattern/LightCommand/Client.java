package DesignPattern.CommandPattern.LightCommand;

/**
 * @author chenmengliang
 * @date 2019/10/9 11:23
 **/
public class Client {
    public static void main(String[] args) {

        Invoker invoker = new Invoker();

        Light light = new Light();

        Command lightOnCmd  = new LightOnCommand(light);
        Command lightOffCmd = new LightOffCommand(light);


        invoker.setOnCommand(lightOnCmd,0);
        invoker.setOffCommand(lightOffCmd,0);

        invoker.onButtonPushed(0);
        invoker.offButtonPushed(0);

    }
}
