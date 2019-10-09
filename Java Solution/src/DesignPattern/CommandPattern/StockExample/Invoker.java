package DesignPattern.CommandPattern.StockExample;

import java.util.ArrayList;

/**
 * @author chenmengliang
 * @date 2019/10/9 12:05
 **/
public class Invoker {

    private ArrayList<Order> orders;

    public Invoker() {
        this.orders = new ArrayList<>();
    }

    /**
     * 接受一个股票的订单
     * 让接收到的一批Stock一起执行 某个命令
     * @param order
     */
    public void takeOrder(Order order){
        orders.add(order);
    }


    /**
     * 执行一批Order
     */
    public void placeOrders(){
        for (Order order :
                orders) {
            order.execute();
        }
    }

    /**
     * 撤销操作
     * 倒回去
     */
    public void undoOrders(){

        for (int index = orders.size()-1;index >= 0;index--){
            orders.get(index).undo();
        }

    }




}
