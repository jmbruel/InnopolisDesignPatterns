package pizzeria;

import pizza.Pizza;
import pizza.factory.PizzaFactory;

public abstract class Pizzeria {
    PizzaFactory pizzaFactory;

    public final Pizza commanderPizza(String type) {
        Pizza pizza = creerPizza(type);
        pizza.preparer();
        pizza.cuire();
        pizza.couper();
        pizza.emballer();
        return pizza;
    }

    public Pizzeria(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    protected Pizza creerPizza(String type) {
        return pizzaFactory.creer(type);
    }
}
