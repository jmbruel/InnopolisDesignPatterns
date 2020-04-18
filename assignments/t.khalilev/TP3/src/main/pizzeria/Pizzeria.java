package main.pizzeria;

import main.pizza.Pizza;

abstract public class Pizzeria {
    public Pizza deliverPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.cook();
        pizza.cut();
        pizza.pack();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}
