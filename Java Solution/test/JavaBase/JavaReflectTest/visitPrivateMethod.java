package JavaBase.JavaReflectTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Keith
 * @date 2019-10-08 16:27
 * 利用反射，访问对象的私有方法
 **/
public class visitPrivateMethod {
    public static void main(String[] args) {
        // 1. 获取Class实例
        Class<Son> sonClass = Son.class;

        // 此处直接通过son对象是不能能够调用{@code printSonMsg}方法的，因为它是private
        Son son = new Son();

        son.setmSonAge(18);

        Method privateMethod;
        try {
            // 2. 获取private method
            // 第一个参数是 私有方法的名称
            // 后面是获取方法的参数类型，参数是Class..... 没有参数就是null
            privateMethod = sonClass.getDeclaredMethod("printSonMsg", String.class, int.class);
            System.out.println(privateMethod.toString());

            // 获取方法的访问权限
            // 只是获取访问权限，并没有修改权限
            // 这里不获取权限会抛出异常
            // visitPrivateMethod can not access a member of class JavaBase.JavaReflectTest.Son with modifiers "private"
            privateMethod.setAccessible(true);

            // 使用{@code invoke}方法反射调用私有方法
            // privateMethod是要调用的私有方法
            // son 参数表明了是要调用这个对象的私有方法
            // 后面是privateMethod方法的参数
            privateMethod.invoke(son, "Hello", 66666);


        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
