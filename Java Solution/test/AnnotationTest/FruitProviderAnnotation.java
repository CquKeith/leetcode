package AnnotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果提供商注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitProviderAnnotation {
    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
