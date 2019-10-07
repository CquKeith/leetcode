package DesignPattern.BuilderPattern.KFCMeal.Builder;

import DesignPattern.BuilderPattern.KFCMeal.Product.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/10/7 11:06
 **/
public class Meal {
    private List<Item> items = new ArrayList<>();

    public Meal addItem(Item item){
        items.add(item);
        return this;
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item :
                items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item :
                items) {
            System.out.print("Item : "+item.name());
            System.out.print(",Packing : "+item.packing().pack());
            System.out.println(",Price: "+item.price());
        }
    }

}
