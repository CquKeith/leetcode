package DesignPattern.PrototypePattern;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:05
 * !!!!!!!记得一定要实现Cloneable接口，否则重新clone方法中，调用super.clone()是失败，返回Null，抛出异常
 **/
public abstract class Shape implements Cloneable{
    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    protected Object clone() {

        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;

    }
}
