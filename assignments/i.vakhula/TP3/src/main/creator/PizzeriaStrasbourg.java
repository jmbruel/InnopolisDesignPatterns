package main.creator;

import main.product.*;

public class PizzeriaStrasbourg extends Pizzeria {
    @Override
    protected Pizza createPizza(PizzaType type) {
        switch (type) {
            case CHEESE:
                return new StrasbourgCheesePizza();
            case PEPPERONI:
                return new StrasbourgPepperoniPizza();
            case VEGGIE:
                return new StrasbourgVeggiePizza();
            default:
                throw new IllegalArgumentException("no such pizza type");
        }
    }
}
