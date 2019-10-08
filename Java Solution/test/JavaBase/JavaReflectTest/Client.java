package JavaBase.JavaReflectTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author Keith
 * @date 2019-10-08 11:19
 **/
public class Client {
    public static void main(String[] args) {

        //printFields();

        printMethods();

    }
    private static void printFields(){
        Class sonClass    = Son.class;

        // 1. 获取所有public成员变量，包括自身的和从父类继承过来的
        //Field[] sonFields = sonClass.getFields();

        // 2. 获取所有仅在本类中声明的成员，包括public private protected default
        Field[] sonFields = sonClass.getDeclaredFields();

        for (Field field :
                sonFields) {
            // 获取访问权限并输出
            int modifier = field.getModifiers();
            System.out.print(Modifier.toString(modifier)+" :");

            //获取类型 和名称并输出
            System.out.println("Type : "+ field.getType().getName() + "; Name : "+field.getName());
        }
    }

    private static void printMethods(){
        Class sonClass    = Son.class;

        // 1.获取所有public方法，包括从Father和Object继承来的
        Method[] methods = sonClass.getMethods();

        // 2. 获取在自己类中声明的所有方法（），不包括继承来的
        //Method[] methods = sonClass.getDeclaredMethods();

        for (Method m :
                methods) {
            System.out.println(m.toString());

            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifier = m.getModifiers();
            System.out.print(Modifier.toString(modifier)+" ");

            //获取并输出方法的返回值类型
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + " "+m.getName()+"(");

            //获取并输出方法的所有参数
            Parameter[] parameters = m.getParameters();
            for (Parameter parameter:
                    parameters) {
                System.out.print(parameter.getType().getName()
                                         + " " + parameter.getName() + ",");
            }

            Class[] exceptions = m.getExceptionTypes();
            if (exceptions.length == 0){
                System.out.println(")");
            }else {
                for (Class c:exceptions){
                    System.out.println(") throws" + c.getName());
                }
            }


        }

    }
}
