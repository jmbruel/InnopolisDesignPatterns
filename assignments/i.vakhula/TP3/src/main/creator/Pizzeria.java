package main.creator;

import main.product.Pizza;
import main.product.PizzaType;

public abstract class Pizzeria {

    public Pizza orderPizza(PizzaType type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(PizzaType type);
}
