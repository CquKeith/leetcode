package DesignPattern.NullObjectPattern;

/**
 * @author chenmengliang
 * @date 2019/10/9 20:04
 **/
public abstract class AbstractCustomers {

    protected String name;

    public AbstractCustomers(String name) {
        this.name = name;
    }

    abstract protected boolean isNil();

    abstract protected String getName();

    @Override
    abstract public String toString();
}
