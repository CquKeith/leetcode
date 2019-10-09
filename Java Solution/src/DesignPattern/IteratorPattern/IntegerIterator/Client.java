package DesignPattern.IteratorPattern.IntegerIterator;

/**
 * @author chenmengliang
 * @date 2019/10/9 18:49
 **/
public class Client {
    public static void main(String[] args) {

        Aggregate aggregate = new IntegerAggregate();

        Iterator integerIterator = aggregate.createIterator();

        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
        //这里就会抛出异常了
        System.out.println(integerIterator.next());


    }
}
