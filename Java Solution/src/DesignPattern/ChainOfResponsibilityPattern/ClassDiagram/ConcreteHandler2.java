package DesignPattern.ChainOfResponsibilityPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:35
 **/
public class ConcreteHandler2 extends AbstractHandler {
    public ConcreteHandler2(AbstractHandler successor) {
        super(successor);
    }

    @Override
    void handleRequest(Request request) {
        if (RequestTypeEnum.TYPE2.getId().equals(request.getTypeEnum().getId())){
            System.out.println(request.getName() + " is handled by ConcreteHandler2");
            return;
        }

        if (null != successor){
            successor.handleRequest(request);
        }

    }
}
