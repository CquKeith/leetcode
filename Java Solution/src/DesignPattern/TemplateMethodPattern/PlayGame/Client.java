package DesignPattern.TemplateMethodPattern.PlayGame;

/**
 * @author chenmengliang
 * @date 2019/10/8 09:42
 **/
public class Client {
    public static void main(String[] args) {
        AbstractGame abstractGame = new BasketballGame();

        abstractGame.playGame();

        System.out.println();

        abstractGame = new FootballGame();

        abstractGame.playGame();

    }
}
