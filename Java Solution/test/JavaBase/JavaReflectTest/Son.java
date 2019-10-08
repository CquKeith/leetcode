package JavaBase.JavaReflectTest;

/**
 * @author Keith
 * @date 2019-10-08 11:16
 **/
public class Son extends Father {

    /**
     * final 的变量，如果是 int long boolean这种基本类型或者String，JVM会直接进行优化
     * 在后面的getter中直接填充FINAL_SEX的值，不会重新获取
     * Integer的就不会被优化
     * 这种变化可以在生成的 class文件中看到
     * 而程序的运行也是根据生成的class文件运行的
     * 也即，如果是final int，即使通过反射来改变了它的值，但是toString方法里面仍然是"Son{FINAL_SEX="1"+...，所有toString的执行结果还是没有改变
     */
    private final int FINAL_SEX = 1;

    private String mSonName;

    protected int mSonAge;

    public String mSonBirthday;

    String address;

    public Son(String mSonName, int mSonAge, String mSonBirthday, String address) {
        this.mSonName = mSonName;
        this.mSonAge = mSonAge;
        this.mSonBirthday = mSonBirthday;
        this.address = address;
    }

    public Son() {

    }

    public int getFINAL_SEX(){
        return FINAL_SEX;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getmSonName() {
        return mSonName;
    }

    public void setmSonName(String mSonName) {
        this.mSonName = mSonName;
    }

    public int getmSonAge() {
        return mSonAge;
    }

    public void setmSonAge(int mSonAge) {
        this.mSonAge = mSonAge;
    }

    public String getmSonBirthday() {
        return mSonBirthday;
    }

    public void setmSonBirthday(String mSonBirthday) {
        this.mSonBirthday = mSonBirthday;
    }

    @Override
    public String toString() {
        return "Son{" +
                       "FINAL_SEX=" + FINAL_SEX +
                       ", mSonName='" + mSonName + '\'' +
                       ", mSonAge=" + mSonAge +
                       ", mSonBirthday='" + mSonBirthday + '\'' +
                       ", address='" + address + '\'' +
                       '}';
    }

    private void printSonMsg(String head, int tail){
        System.out.println(head + " "+tail);
    }


}
