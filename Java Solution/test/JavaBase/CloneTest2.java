package JavaBase;

/**
 * @author chenmengliang
 * @date 2019/9/10 08:46
 **/
public class CloneTest2 implements Cloneable{
    public Student st;
    public static void main(String[] args) throws CloneNotSupportedException {
        Student  s1 = new Student("Tom");
        CloneTest2 t1 = new CloneTest2();
        t1.st = s1;
        CloneTest2 t2 = (CloneTest2) t1.clone();//t2 是新的一个对象，但是t2 的st 依然指向s1 因为是浅拷贝
    }

}
class Student{
    public String name;
    public Student(String name){
        this.name = name;
    }
}