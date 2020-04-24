package pizzeria.impl;

import pizza.factory.impl.PizzaFactoryStrasbourg;
import pizzeria.Pizzeria;

public class PizzeriaStrasbourg extends Pizzeria {
    public PizzeriaStrasbourg() {
        super(new PizzaFactoryStrasbourg());
    }


}
