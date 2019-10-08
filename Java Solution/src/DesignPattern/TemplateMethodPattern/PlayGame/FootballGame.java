package DesignPattern.TemplateMethodPattern.PlayGame;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:44
 **/
public class FootballGame extends AbstractGame {
    @Override
    void initialize() {
        System.out.println("Initialize Football Game");
    }

    @Override
    void startGame() {
        System.out.println("Start Football Game");
    }

    @Override
    void endGame() {
        System.out.println("End Football Game");
    }
}
