package JavaIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author chenmengliang
 * @date 2020/3/19 21:35
 **/
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String s = "Hello World!";
        outputStream.write(s.getBytes());

        outputStream.close();



    }
}
