package DesignPattern.CommandPattern.LightCommand;

/**
 * @author chenmengliang
 * @date 2019/10/9 11:20
 **/
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
