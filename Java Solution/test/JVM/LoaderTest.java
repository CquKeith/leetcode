package JVM;

/**
 * @author chenmengliang
 * @date 2019/9/24 15:55
 * 类加载过程
 **/
public class LoaderTest {

    static {
        i = 0;                  //给变量赋值可以正常编译通过
        //System.out.println(i); // 这句 编译器会提示非法向前引用
    }
    static int i;
    static class Parent{
        public static int A = 1;
        static {
            A = 2;
        }
    }
    static class Sub extends Parent{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);      //2 父类定义的static语句快的执行要优先于子类
    }


}

