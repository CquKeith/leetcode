package JavaBase;

/**
 * @author chenmengliang
 * @date 2020/3/19 23:14
 **/
public class OuterClassTest {
    private int a = 1;
    protected int b = 2;
    public int c = 3;

    private static int sa = 1;
    protected  static int sb = 2;
    public static int sc = 3;



    public static void main(String[] args) {
        OuterClassTest outerClassTest = new OuterClassTest();
        innerClass innerClass = outerClassTest.new innerClass();
        staticInnerClass staticInnerClass = new staticInnerClass();
        innerClass.innerA = 120;
        innerClass.print();
        staticInnerClass.staticInnerA = -100;
        staticInnerClass.print();


    }
    class innerClass{

        private int innerA = 100;

         void print() {
             System.out.println(a);
             System.out.println(b);
             System.out.println(c);
             System.out.println(sa);
             System.out.println(sb);
             System.out.println(sc);
             System.out.println(innerA);
        }
    }

    static class staticInnerClass {

        private int staticInnerA = 200;
        void print() {
            System.out.println(sa);
            System.out.println(staticInnerA);
        }


    }



}
