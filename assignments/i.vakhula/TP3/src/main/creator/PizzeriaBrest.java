package main.creator;

import main.product.*;

public class PizzeriaBrest extends Pizzeria {
    @Override
    protected Pizza createPizza(PizzaType type) {
        switch (type) {
            case CHEESE:
                return new BrestCheesePizza();
            case PEPPERONI:
                return new BrestPepperoniPizza();
            case VEGGIE:
                return new BrestVeggiePizza();
            default:
                throw new IllegalArgumentException("no such pizza type");
        }
    }
}
