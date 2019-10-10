package DesignPattern.MediatorPattern.ChatRoom;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:49
 **/
public class ChatRoomUtil {

    public static void showMessage(User user,String message){
        System.out.println(user.getName()+" : "+message);
    }

}
