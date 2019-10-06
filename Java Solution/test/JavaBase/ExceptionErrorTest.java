package JavaBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * @author chenmengliang
 * @date 2019/9/25 18:47
 **/
public class ExceptionErrorTest {
    public static void main(String[] args) {
        // 1. OOM Error
        new ExceptionErrorTest().oomERROR();

        //2. 堆栈溢出错误。当一个应用递归调用的层次太深而导致堆栈溢出时抛出该错误。
        //new ExceptionErrorTest().stackOverFlowError();

        // 3. RuntimeException
        //new ExceptionErrorTest().runtimeException();

        //4. IOException
        //new ExceptionErrorTest().ioException();
    }

    private void oomERROR() {

        try {
            while (true){
                byte[] bytes = new byte[Integer.MAX_VALUE - 100000000];

            }

        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    private void stackOverFlowError() {
        stackOverFlowError();
    }

    private void runtimeException() {

        //1. NullPointer
        try {
            String s = "1";
            s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        //2.ClassCastException
        try {
            Object o = new Date();
            String s = (String) o;
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }

    }

    private void ioException() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("hello.txt"));
            int b ;
            while ((b = fileInputStream.read()) != -1){
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
