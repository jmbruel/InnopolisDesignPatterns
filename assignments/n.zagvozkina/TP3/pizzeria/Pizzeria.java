package pizzeria;

import pizza.Pizza;

public abstract class Pizzeria {
    public Pizza orderPizza(String type) {

        Pizza pizza=null;
        pizza = createPizza(type);

        pizza.preparer();
        pizza.cuire();
        pizza.couper();
        pizza.emballer();

        return pizza;
    }
    protected abstract Pizza createPizza(String type);

}