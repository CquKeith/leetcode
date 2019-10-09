package DesignPattern.CommandPattern.StockExample;

/**
 * @author chenmengliang
 * @date 2019/10/9 12:02
 * 命令的接收者
 **/
public class Stock {

    private String name = "AntFin";
    private int quality = 1;


    public void buyStock(){
        System.out.println("Buy "+ name + " Stock: quality "+quality);
    }
    public void sellStock(){
        System.out.println("Sell "+ name + " Stock: quality "+quality);
    }

}
