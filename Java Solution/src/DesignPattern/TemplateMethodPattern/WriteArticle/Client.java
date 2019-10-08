package DesignPattern.TemplateMethodPattern.WriteArticle;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:35
 **/
public class Client {
    public static void main(String[] args) {
        AbstractWriteArticle abstractWriteArticle = new TomWriteArticle();

        abstractWriteArticle.writeArticle();

    }
}
