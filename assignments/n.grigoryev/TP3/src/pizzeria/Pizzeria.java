package pizzeria;

import pizza.Pizza;

public abstract class Pizzeria {
    public Pizza createPizza(String name) {
        Pizza pizza = create(name);

        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.wrap();

        return pizza;
    }

    protected abstract Pizza create(String name);
}