package DesignPattern.ChainOfResponsibilityPattern.ClassDiagram;

/**
 * @author chenmengliang
 * @date 2019/10/7 12:35
 **/
public abstract class AbstractHandler {

    protected AbstractHandler successor;

    public AbstractHandler(AbstractHandler successor) {
        //定义下一个处理请求的Handler
        this.successor = successor;
    }

    abstract void handleRequest(Request request);

}
