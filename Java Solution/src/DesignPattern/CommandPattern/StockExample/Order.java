package DesignPattern.CommandPattern.StockExample;

/**
 * @author chenmengliang
 * @date 2019/10/912:01
 * Command 接口
 **/

public interface Order {
    void execute();

    void undo();
}
