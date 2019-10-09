package DesignPattern.CommandPattern.StockExample;

/**
 * @author chenmengliang
 * @date 2019/10/9 12:11
 **/
public class Client {
    public static void main(String[] args) {

        Invoker invoker = new Invoker();

        Stock stock = new Stock();

        // 指定对于 stock 参数 的具体的Command：买入和卖出
        // 将这些命令排队
        invoker.takeOrder(new BuyStockOrder(stock));
        invoker.takeOrder(new SellStockOrder(stock));

        // 执行所有在排队的 所有Receiver的ConcreteCommand
        invoker.placeOrders();
        System.out.println();

        invoker.undoOrders();

    }
}
