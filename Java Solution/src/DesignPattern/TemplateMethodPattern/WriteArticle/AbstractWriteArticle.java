package DesignPattern.TemplateMethodPattern.WriteArticle;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:31
 **/
public abstract class AbstractWriteArticle {

    /**
     * 写引言
     */
    abstract void writeIntroduction();

    /**
     * 写正文
     */
    abstract void writeContent();

    /**
     * 写结尾
     */
    abstract void writeLast();

    protected final void writeArticle(){
        writeIntroduction();

        writeContent();

        writeLast();
    }

}
