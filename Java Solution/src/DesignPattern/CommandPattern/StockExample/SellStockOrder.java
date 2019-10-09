package DesignPattern.CommandPattern.StockExample;

/**
 * @author chenmengliang
 * @date 2019/10/9 12:04
 **/
public class SellStockOrder implements Order {

    private Stock stock;

    public SellStockOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sellStock();
    }

    @Override
    public void undo() {
        stock.buyStock();
    }
}
