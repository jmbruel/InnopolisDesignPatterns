package main;

import main.creator.Pizzeria;
import main.creator.PizzeriaBrest;
import main.creator.PizzeriaStrasbourg;
import main.product.Pizza;
import main.product.PizzaType;

public class PizzaTestDrive {

    public static void main(String[] args) {
        Pizzeria brestPizzeria = new PizzeriaBrest();
        Pizzeria strasbourgPizzeria = new PizzeriaStrasbourg();

        Pizza pizza = brestPizzeria.orderPizza(PizzaType.CHEESE);
        orderIsReady(pizza.getName());

        pizza = strasbourgPizzeria.orderPizza(PizzaType.VEGGIE);
        orderIsReady(pizza.getName());
    }

    private static void orderIsReady(String pizzaName) {
        System.out.println("Order is ready: " + pizzaName + "\n" + "-".repeat(20));
    }

}
