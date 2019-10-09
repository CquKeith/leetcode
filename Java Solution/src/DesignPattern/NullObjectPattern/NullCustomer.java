package DesignPattern.NullObjectPattern;

/**
 * @author chenmengliang
 * @date 2019/10/9 20:07
 **/
public class NullCustomer extends AbstractCustomers {
    public NullCustomer() {
        super(null);
    }

    @Override
    protected boolean isNil() {
        return true;
    }

    @Override
    protected String getName() {
        return "Null Customer,No Name,Sorry...";
    }

    @Override
    public String toString() {
        return "NullCustomer{" +
                       "name='" + name + '\'' +
                       '}';
    }
}
