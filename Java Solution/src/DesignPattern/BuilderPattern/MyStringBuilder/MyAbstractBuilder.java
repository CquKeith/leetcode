package DesignPattern.BuilderPattern.MyStringBuilder;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:33
 **/
public abstract class MyAbstractBuilder{
    protected int[] value;
    protected int count;

    public MyAbstractBuilder(int capacity){
        count = 0;
        value = new int[capacity];
    }

    protected MyAbstractBuilder append(char c){

        ensureCapacityInternal(count + 1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        if (minimumCapacity - value.length > 0){
            expandCapacity(minimumCapacity);
        }
    }

    private void expandCapacity(int minimumCapacity) {
        // 默认扩容的长度，以避免多次调用扩容，影响性能
        int newCapacity = value.length * 2 + 2;
        // 默认的扩容长度还不够，则使用传入的最小容量
        if (newCapacity < minimumCapacity){
            newCapacity = minimumCapacity;
        }

        //assert
        if (newCapacity < 0){
            if (minimumCapacity < 0){
                throw new OutOfMemoryError();
            }
            //如果是因为默认扩容 溢出了
            newCapacity = Integer.MAX_VALUE;
        }
        //拷贝
        value = Arrays.copyOf(value,newCapacity);
        System.out.println("expandCapacity");
    }

}
