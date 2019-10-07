package DesignPattern.ChainOfResponsibilityPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:35
 **/
public class ConcreteHandler1 extends AbstractHandler {
    public ConcreteHandler1(AbstractHandler successor) {
        super(successor);
    }

    @Override
    void handleRequest(Request request) {
        if (RequestTypeEnum.TYPE1.getId().equals(request.getTypeEnum().getId())){
            System.out.println(request.getName() + " is handled by ConcreteHandler1");
            return;
        }

        if (null != successor){
            successor.handleRequest(request);
        }

    }
}
