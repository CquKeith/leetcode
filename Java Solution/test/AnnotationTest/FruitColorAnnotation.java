package AnnotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果颜色注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColorAnnotation {
    public enum Color{GREEN,RED,BLUE}

    Color fruitColor() default Color.GREEN;
}
