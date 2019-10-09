package DesignPattern.NullObjectPattern;

/**
 * @author chenmengliang
 * @date 2019/10/9 20:07
 **/
public class RealCustomers extends AbstractCustomers {

    public RealCustomers(String name) {
        super(name);
    }

    @Override
    protected boolean isNil() {
        return false;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RealCustomers{" +
                       "name='" + name + '\'' +
                       '}';
    }
}
