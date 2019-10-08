package JavaBase.JavaReflectTest;

import java.lang.reflect.Field;

/**
 * @author Keith
 * @date 2019-10-08 17:34
 * 利用反射，在运行时修改私有常量
 **/
public class modifyPrivateFinalField {
    public static void main(String[] args) {
        Class<Son> sonClass = Son.class;
        Son son = new Son("小明",10,"20090101","重庆");

        System.out.println(son.toString());//Son{FINAL_SEX=1, mSonName='小明', mSonAge=10, mSonBirthday='20090101', address='重庆'}


        //下面将son的private final成员 ：sex修改为0
        try {
            Field field = sonClass.getDeclaredField("FINAL_SEX");
            field.setAccessible(true);

            System.out.println("Before Modification : Sex : "+field.get(son));//Before Modification : Sex : 1

            field.set(son,0);

            System.out.println("After Modification : Sex : "+field.get(son));//After Modification : Sex : 0

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(son.toString());//Son{FINAL_SEX=1, mSonName='小明', mSonAge=10, mSonBirthday='20090101', address='重庆'}



    }
}
