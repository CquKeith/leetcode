package DesignPattern.ChainOfResponsibilityPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:39
 **/
public enum  RequestTypeEnum {
    TYPE1(1,"Request Type 1"),
    TYPE2(2,"Request Type 2");

    RequestTypeEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private Integer id;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
