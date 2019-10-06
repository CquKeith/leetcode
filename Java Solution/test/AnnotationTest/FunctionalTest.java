package AnnotationTest;

/**
 * @author chenmengliang
 * @date 2019/9/26 10:43
 **/
@FunctionalInterface
public interface FunctionalTest {
    //@FunctionalInterface 提示编译器，interface中只能有一个abstract方法
    void sayHello();

    //但是可以有default和static方法
    default void sayHi(){
        System.out.println("Hi~");
    }
    static void sayMessage(String msg){
        System.out.println(msg);
    }

    //interface也是继承自Object的，自然也可以OverrideObject的方法
    @Override
    boolean equals(Object object);
}
