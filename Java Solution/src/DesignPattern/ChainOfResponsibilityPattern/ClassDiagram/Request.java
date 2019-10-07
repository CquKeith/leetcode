package DesignPattern.ChainOfResponsibilityPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:39
 **/
public class Request {
    private RequestTypeEnum typeEnum;
    private String name;

    public Request(RequestTypeEnum typeEnum, String name) {
        this.typeEnum = typeEnum;
        this.name = name;
    }

    public RequestTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(RequestTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
