package DesignPattern.BuilderPattern.KFCMeal.Builder;

import DesignPattern.BuilderPattern.KFCMeal.Product.ChickenBurger;
import DesignPattern.BuilderPattern.KFCMeal.Product.Coke;
import DesignPattern.BuilderPattern.KFCMeal.Product.Pepsi;
import DesignPattern.BuilderPattern.KFCMeal.Product.VegBurger;

/**
 * @author chenmengliang
 * @date 2019/10/7 11:10
 **/
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();

        meal.addItem(new VegBurger())
                .addItem(new Coke());

        return meal;

    }
    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();

        meal.addItem(new ChickenBurger())
                .addItem(new Pepsi());

        return meal;

    }

}
