package DesignPattern.FactoryMethodPattern;

public enum ProductTypeEnum {
    TYPE1(1,"产品类型1"),
    TYPE2(2,"产品类型2");

    ProductTypeEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private int id;
    private String desc;

    @Override
    public String toString() {
        return "产品类型id："+id+" 描述："+desc;
    }
}
