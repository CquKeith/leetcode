package JVM;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chenmengliang
 * @date 2019/11/21 19:35
 * static成员方法，在内存中维持一个拷贝
 * 那么普通的成员方法呢？在内存中维持几个拷贝？
 * 实例对象在堆内存中都存储了什么东西？
 **/
public class MethodAndStaticTest {
    private static int staticInt;

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        MethodAndStaticTest object1 = new MethodAndStaticTest();
        MethodAndStaticTest object2 = new MethodAndStaticTest();

        Field o1StaticInt = object1.getClass().getDeclaredField("staticInt");
        Field o2StaticInt = object2.getClass().getDeclaredField("staticInt");

        System.out.println(o1StaticInt == o2StaticInt);


        Method o1StaticMethod = object1.getClass().getDeclaredMethod("staticMethod");
        Method o2StaticMethod = object2.getClass().getDeclaredMethod("staticMethod");


        System.out.println(o1StaticMethod == o2StaticMethod);

    }
    public  void staticMethod(){

    }
}
