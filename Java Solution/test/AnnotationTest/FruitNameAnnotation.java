package AnnotationTest;

import java.lang.annotation.*;

/**
 * 水果名称注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitNameAnnotation {
    String value() default "";
}
