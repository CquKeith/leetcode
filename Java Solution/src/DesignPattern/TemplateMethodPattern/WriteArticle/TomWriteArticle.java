package DesignPattern.TemplateMethodPattern.WriteArticle;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:33
 **/
public class TomWriteArticle extends AbstractWriteArticle {
    @Override
    void writeIntroduction() {
        System.out.println("Tom write introduction");
    }

    @Override
    void writeContent() {
        System.out.println("Tom write content");
    }

    @Override
    void writeLast() {
        System.out.println("Tom write the last");
    }


}
