package AnnotationTest;

import java.lang.reflect.Field;

/**
 * @author chenmengliang
 * @date 2019/9/24 15:13
 **/
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        //此处应该是getDeclaredFields 而不应该是getField
        Field[] fields = clazz.getDeclaredFields();
        for (Field f :
                fields) {
            if (f.isAnnotationPresent(FruitNameAnnotation.class)) {
                FruitNameAnnotation fruitNameAnnotation = f.getAnnotation(FruitNameAnnotation.class);
                System.out.println("水果名称：" + fruitNameAnnotation.value());
            }

            if (f.isAnnotationPresent(FruitColorAnnotation.class)){
                FruitColorAnnotation fruitColorAnnotation = f.getAnnotation(FruitColorAnnotation.class);
                System.out.println("水果颜色："+fruitColorAnnotation.fruitColor());
            }

            if (f.isAnnotationPresent(FruitProviderAnnotation.class)){
                FruitProviderAnnotation fruitProviderAnnotation = f.getAnnotation(FruitProviderAnnotation.class);
                System.out.println("水果供应商：id："+fruitProviderAnnotation.id()+" 名称"+fruitProviderAnnotation.name()+"address:"+fruitProviderAnnotation.address());
            }

        }
    }
}
