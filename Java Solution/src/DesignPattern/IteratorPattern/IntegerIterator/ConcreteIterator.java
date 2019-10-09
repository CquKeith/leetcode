package DesignPattern.IteratorPattern.IntegerIterator;

/**
 * @author chenmengliang
 * @date 2019/10/9 18:13
 **/
public class ConcreteIterator<T> implements Iterator {

    private T[] items;
    private int index;

    public ConcreteIterator(T[] items) {
        index = 0;
        this.items = items;
    }

    @Override
    public T next() {

        if (index > items.length - 1){
            throw new ArrayIndexOutOfBoundsException("超过数组长度了");
        }

        return items[index++];
    }

    @Override
    public boolean hasNext() {
        return index <= items.length-1;
    }
}
