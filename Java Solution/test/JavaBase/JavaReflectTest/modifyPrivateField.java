package JavaBase.JavaReflectTest;

import java.lang.reflect.Field;

/**
 * @author Keith
 * @date 2019-10-08 17:12
 **/
public class modifyPrivateField {

    public static void main(String[] args) {
        Class<Son> sonClass = Son.class;
        Son son = new Son();
        son.setmSonAge(10);//Son{mSonName='null', mSonAge=10, mSonBirthday='null'}

        System.out.println(son.toString());


        try {
            Field field = sonClass.getDeclaredField("mSonAge");

            field.set(son,20);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------");
        System.out.println(son.toString());//Son{mSonName='null', mSonAge=20, mSonBirthday='null'}

    }


}
