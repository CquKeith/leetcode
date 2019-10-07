package DesignPattern.PrototypePattern;

import java.util.Hashtable;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:11
 **/
public class ShapeCache {
    private static Hashtable<String,Shape> stringShapeHashtable
            = new Hashtable<>();

    public static Shape getShape(String shapeId){
        Shape cachedShape = stringShapeHashtable.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    /**
     * 对每种形状都要进行数据库查询，并创建该形状
     * 比如，我们要添加三种形状
     */
    public static void loadCache(){
        Shape circle = new Circle();
        circle.setId("1");
        stringShapeHashtable.put(circle.getId(),circle);

        Shape rectangle = new Rectangle();
        rectangle.setId("2");
        stringShapeHashtable.put(rectangle.getId(),rectangle);

        Shape square = new Square();
        square.setId("3");
        stringShapeHashtable.put(square.getId(),square);

    }

}
