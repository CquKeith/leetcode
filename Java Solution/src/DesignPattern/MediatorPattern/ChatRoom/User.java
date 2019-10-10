package DesignPattern.MediatorPattern.ChatRoom;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:50
 **/
public class User {

    public void sendMessage(String message){
        ChatRoomUtil.showMessage(this,message);
    }

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
