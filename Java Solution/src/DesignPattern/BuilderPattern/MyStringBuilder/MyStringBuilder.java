package DesignPattern.BuilderPattern.MyStringBuilder;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:55
 **/
public class MyStringBuilder extends MyAbstractBuilder {

    public MyStringBuilder() {
        super(16);
    }

    public MyStringBuilder(int capacity) {
        // 默认长度16
        super(capacity);
    }

    @Override
    public String toString() {
        return new String(value,0,count);
    }

    @Override
    protected MyAbstractBuilder append(char c) {
        super.append(c);
        return this;
    }
}
