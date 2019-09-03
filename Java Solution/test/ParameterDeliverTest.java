import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/3 21:34
 * java 中 参数传递的测试
 *
 * 具体参考知乎图解Java中的参数传递
 * https://zhuanlan.zhihu.com/p/24556934
 **/
public class ParameterDeliverTest {
    public static void main(String[] args) {
        int a = 10;
        String s = "hello";
        int[] array = new int[2];

        change(a);
        change(s);
        change(array);
        System.out.println(a);
        System.out.println(s);
        System.out.println(Arrays.toString(array));


    }
    private static void change(int a){
        a += 10;
    }
    private static void change(String s){
        s = "world";
    }
    private static void change(int[] array){
        array[0] = 1;
        array[1] = 2;
    }
}
