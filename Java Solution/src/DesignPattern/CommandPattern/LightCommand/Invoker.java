package DesignPattern.CommandPattern.LightCommand;

/**
 * @author chenmengliang
 * @date 2019/10/9 11:24
 * 遥控器
 **/
public class Invoker {

    private Command[] onCommand;
    private Command[] offCommand;

    //开关各有7个按钮
    private final int slotNum = 7;

    public Invoker() {
        this.onCommand = new LightOnCommand[slotNum];
        this.offCommand = new LightOffCommand[slotNum];
    }

    //设置按钮的命令
    public void setOnCommand(Command command,int slot) {
        onCommand[slot] = command;
    }
    public void setOffCommand(Command command,int slot) {
        offCommand[slot] = command;
    }
    //指令按钮的命令
    public void onButtonPushed(int slot){
        onCommand[slot].execute();
    }
    public void offButtonPushed(int slot){
        offCommand[slot].execute();
    }


}
