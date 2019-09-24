package AnnotationTest;

import java.lang.annotation.Repeatable;

/**
 * @author chenmengliang
 * @date 2019/9/24 14:30
 **/
@MyAnnotation(id = 1,msg = "hello")
@Person(role = "PM")
@Person(role = "artist")
public class TestAnnotation {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        new TestAnnotation().sayHi();

        System.out.println(TestAnnotation.class.isAnnotationPresent(MyAnnotation.class));
        System.out.println((TestAnnotation.class.getAnnotations().length));
    }


    @Deprecated
    public void sayHi(){
        System.out.println("Hi");
    }

}
@interface Persons{
    Person[] value();
}

@Repeatable(Persons.class)
@interface Person{
    String role() default "";
}