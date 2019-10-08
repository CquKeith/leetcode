package DesignPattern.TemplateMethodPattern.PlayGame;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:44
 **/
public class BasketballGame extends AbstractGame {
    @Override
    void initialize() {
        System.out.println("Initialize Basketball Game");
    }

    @Override
    void startGame() {
        System.out.println("Start Basketball Game");
    }

    @Override
    void endGame() {
        System.out.println("End Basketball Game");
    }
}
