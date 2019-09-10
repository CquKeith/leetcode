package JavaBase;

/**
 * @author chenmengliang
 * @date 2019/9/9 22:38
 **/
public class BaseTypeSize {
    public static void main(String[] args) {

        System.out.println(Byte.SIZE);//8

        System.out.println(Short.SIZE);//16
        System.out.println(Character.SIZE);//16

        System.out.println(Integer.SIZE);//32
        System.out.println(Float.SIZE);//32

        System.out.println(Double.SIZE);//64
        System.out.println(Long.SIZE);//64
        //System.out.println(Boolean.SIZE);//无此方法 jvm编译期间转换成int对待

    }
}
