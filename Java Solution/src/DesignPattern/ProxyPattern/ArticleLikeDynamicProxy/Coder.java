package DesignPattern.ProxyPattern.ArticleLikeDynamicProxy;

/**
 * @author chenmengliang
 * @date 2019/10/20 22:49
 **/
public class Coder implements Programmer {
    @Override
    public void coding() {
        System.out.println("Coder write a new article....");
    }
}
