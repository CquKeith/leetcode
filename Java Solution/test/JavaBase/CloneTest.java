package JavaBase;

/**
 * @author chenmengliang
 * @date 2019/9/10 08:46
 * 深拷贝浅拷贝测试
 * 但是本方法不太好，Effective Java中不提倡本方法，建议使用构造方法（用一个对象去构造另一个对象，深拷贝）
 **/
public class CloneTest implements Cloneable{
    private int [] arr;
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest e1 = new CloneTest();
        CloneTest e2 = null;

        try {
            e2 = e1.clone();
            e1.set(2,222);
            System.out.println(e2.get(2));      ///  222
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

    }

    public CloneTest(){
        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
    }
    public void set(int index,int value){
        arr[index] = value;
    }
    public int get(int index){
        return arr[index];
    }

    @Override
    protected CloneTest clone() throws CloneNotSupportedException {
        CloneTest result = (CloneTest) super.clone();

        //下面是深拷贝的步骤
        result.arr = new int[arr.length];
        System.arraycopy(arr, 0, result.arr, 0, 10);


        return result;
    }
}
