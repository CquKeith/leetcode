package AnnotationTest;

/**
 * @author chenmengliang
 * @date 2019/9/24 15:14
 **/
public class Apple {
    @FruitNameAnnotation("Apple")
    private String name;

    @FruitColorAnnotation(fruitColor = FruitColorAnnotation.Color.GREEN)
    private String appleColor;

    @FruitProviderAnnotation(id = 1,name = "富士康",address = "重庆")
    private String appleProvider;

}
