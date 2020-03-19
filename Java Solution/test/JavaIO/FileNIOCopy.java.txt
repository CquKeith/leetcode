package JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chenmengliang
 * @date 2020/3/19 21:09
 * NIO 的测试
 **/
public class FileNIO {
    public static void main(String[] args) throws IOException {
        String src = "./test/JavaIO/FileNIO.java";
        String dest = "./test/JavaIO/FileNIOCopy.java.txt";
        fastCopy(src, dest);
    }

    /**
     * src文件通过NIO 拷贝到dest
     * @param src
     * @param dest
     */
    private static void fastCopy(String src, String dest) throws IOException {

        /* 获得 源文件的输入字节流*/
        FileInputStream fileInputStream = new FileInputStream(src);

        /* 获得输出文件的输出字节流 */
        FileOutputStream fileOutputStream = new FileOutputStream(dest);

        /* 获得输入文件的通道 */
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        /* 获得输出文件的通道 */
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        /* 在直接内存，分配1024字节作为缓冲区 */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {

            /* 从输入通道读取到缓冲区，如果返回-1，说明EOF */
            if (fileInputStreamChannel.read(buffer) == -1) {
                break;
            }

            /* 切换读写 */
            buffer.flip();

            /* 把数据从缓冲区写到channel */
            fileOutputStreamChannel.write(buffer);

            /* 清空缓冲区 */
            buffer.clear();

        }


    }
}
