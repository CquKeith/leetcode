package DesignPattern.MediatorPattern.ChatRoom;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:52
 **/
public class Client {
    public static void main(String[] args) {
        User tom = new User("Tom");
        User jerry = new User("Jerry");

        tom.sendMessage("Hello,I am Tom");

        jerry.sendMessage("Hi Tom,I am"+jerry.getName());
    }
}
