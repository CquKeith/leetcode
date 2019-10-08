package DesignPattern.TemplateMethodPattern.WriteArticle;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:33
 **/
public class JerryWriteArticle extends AbstractWriteArticle {
    @Override
    void writeIntroduction() {
        System.out.println("Jerry write introduction");
    }

    @Override
    void writeContent() {
        System.out.println("Jerry write content");
    }

    @Override
    void writeLast() {
        System.out.println("Jerry write the last");
    }
}
