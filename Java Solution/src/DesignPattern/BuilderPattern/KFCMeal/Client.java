package DesignPattern.BuilderPattern.KFCMeal;

import DesignPattern.BuilderPattern.KFCMeal.Builder.Meal;
import DesignPattern.BuilderPattern.KFCMeal.Builder.MealBuilder;

/**
 * @author chenmengliang
 * @date 2019/10/7 11:12
 **/
public class Client {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal:");
        vegMeal.showItems();
        System.out.println("Total Cost:"+vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("NonVeg Meal:");
        nonVegMeal.showItems();
        System.out.println("Total Cost:"+nonVegMeal.getCost());

    }
}
