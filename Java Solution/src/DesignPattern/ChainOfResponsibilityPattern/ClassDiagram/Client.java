package DesignPattern.ChainOfResponsibilityPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:34
 **/
public class Client {
    public static void main(String[] args) {

        AbstractHandler abstractHandler1 = new ConcreteHandler1(null);
        AbstractHandler abstractHandler2 = new ConcreteHandler2(abstractHandler1);


        Request request1 = new Request(RequestTypeEnum.TYPE1,"Request1");
        Request request2 = new Request(RequestTypeEnum.TYPE2,"Request2");

        abstractHandler2.handleRequest(request1);
        abstractHandler2.handleRequest(request2);

    }
}
