package DesignPattern.ProxyPattern.ArticleLikeDynamicProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author chenmengliang
 * @date 2019/10/20 22:49
 **/
public class Client {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Coder coder = new Coder();

        // 实现动态代理
        Programmer programmerWaterArmy = (Programmer) Proxy.newProxyInstance(Coder.class.getClassLoader(),Coder.class.getInterfaces(),((proxy, method, args1) -> {
            if (method.getName().equals("coding")) {
                method.invoke(coder, args1);
                System.out.println("水军点赞");
            } else {
                return method.invoke(coder, args1);
            }
            return null;
        }));

        // Constructor 的方法构造实例
        //Constructor constructor = Coder.class.getDeclaredConstructor();
        //constructor.setAccessible(true);
        //
        //Coder coder1 = (Coder) constructor.newInstance();
        //coder1.coding();

        programmerWaterArmy.coding();
    }
}
