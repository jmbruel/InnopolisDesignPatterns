package pizzeria.impl;

import pizza.factory.impl.PizzaFactoryBrest;
import pizzeria.Pizzeria;

public class PizzeriaBrest extends Pizzeria {
    public PizzeriaBrest() {
        super(new PizzaFactoryBrest());
    }
}
