package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Keith
 * @date 2019-09-17 14:48
 * Java 文件复制
 **/
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //System.out.println(new File("./test/JavaIO/FileCopy.java").getCanonicalPath());
        copyFile("./test/JavaIO/FileCopy.java","./test/JavaIO/FileCopy.java.txt");
    }

    /**
     *
     * @param src
     * @param dist
     * @throws IOException
     */
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;
        //read() 最多读取buffer.length 个字节
        //返回的是实际读到的字节数
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer,0,cnt);
        }
        in.close();
        out.close();
    }
}
