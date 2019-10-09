package DesignPattern.IteratorPattern.IterateNames;

/**
 * @author chenmengliang
 * @date 2019/10/9 19:36
 **/
public class Client {

    public static void main(String[] args) {

        Container container = new NameRepository();

        Iterator iterator = container.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
