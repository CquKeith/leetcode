package JavaIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2020/3/19 21:35
 * socket NIO 使用selector，非阻塞
 **/
public class NIOServer {
    public static void main(String[] args) throws IOException {

        /*创建选择器*/
        Selector selector = Selector.open();

        /*将通道注册到选择器上*/
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        /* 开启ServerSocket监听 */
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(inetSocketAddress);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {

                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    //
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();

                    // 服务器为每一个连接创建一个socketChannel
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);

                    // 新的连接主要是为了从客户端读取数据
                    socketChannel.register(selector, SelectionKey.OP_READ);


                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    System.out.println(readDataFromSocketChannel(socketChannel));
                    socketChannel.close();
                }

                iterator.remove();

            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel socketChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            buffer.clear();

            if (socketChannel.read(buffer) == -1) {
                break;
            }
            buffer.flip();

            int limit = buffer.limit();
            char[] dest = new char[limit];
            for (int i = 0; i < limit; i++) {
                dest[i] = (char) buffer.get(i);
            }
            stringBuilder.append(dest);

            buffer.clear();

        }
        return stringBuilder.toString();
    }
}
