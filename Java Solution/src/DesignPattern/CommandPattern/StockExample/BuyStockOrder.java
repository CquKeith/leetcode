package DesignPattern.CommandPattern.StockExample;

/**
 * @author chenmengliang
 * @date 2019/10/9 12:04
 **/
public class BuyStockOrder implements Order {

    private Stock stock;

    public BuyStockOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buyStock();
    }

    @Override
    public void undo() {
        stock.sellStock();
    }
}
