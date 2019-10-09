package DesignPattern.IteratorPattern.IntegerIterator;

/**
 * @author chenmengliang
 * @date 2019/10/9 18:32
 **/
public class IntegerAggregate implements Aggregate {

    private Integer[] items;

    public IntegerAggregate() {
        this.items = new Integer[10];
        for (int i = 0; i < 10; i++) {
            items[i] = i;
        }
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator<>(items);
    }
}
