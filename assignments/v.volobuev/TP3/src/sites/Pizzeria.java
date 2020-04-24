package sites;

import menu.Pizza;

abstract public class Pizzeria {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.bake();
        pizza.slice();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
