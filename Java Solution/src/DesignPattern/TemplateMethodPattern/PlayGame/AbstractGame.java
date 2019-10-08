package DesignPattern.TemplateMethodPattern.PlayGame;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:43
 **/
public abstract class AbstractGame {
    abstract void initialize();
    abstract void startGame();
    abstract void endGame();

    public final void playGame(){
        initialize();
        startGame();
        endGame();
    }
}
