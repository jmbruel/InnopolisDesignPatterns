package pizzeria;

import pizza.Pizza;

/**
 * Pizzeria classes implement Factory pattern for pizzas.
 */
abstract public class Pizzeria {
    /**
     * Kinds of pizza each pizzeria has to support.
     * Enum fits best here, as to not allow for typo errors with strings which will only be
     * discovered at runtime, instead of compile time.
     */
    public enum PizzaKind {
        PEPPERONI,
        MARGARITA
    }

    public Pizza deliverPizza(PizzaKind kind) {
        Pizza pizza = createPizza(kind);

        pizza.make();
        pizza.cut();
        pizza.deliver();

        return pizza;
    }

    abstract Pizza createPizza(PizzaKind type);
}
