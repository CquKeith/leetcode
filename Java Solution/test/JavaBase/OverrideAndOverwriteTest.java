package JavaBase;

/**
 * @author chenmengliang
 * @date 2019/9/17 17:08
 **/
public class OverrideAndOverwriteTest {

    public static void main(String[] args) {
        overrideTest();
    }

    private static void overrideTest(){

        OverrideAndOverwriteTest father = new SonClass();
        SonClass sonClass = (SonClass) father;

        father.foo();//Son foo
        sonClass.foo();//Son foo



    }
    public void foo(){
        System.out.println("Father foo");
    }

}

class SonClass extends OverrideAndOverwriteTest{
    @Override
    public void foo(){
        System.out.println("Son soo");
    }
}
