package pizzas.impl;

import pizzas.Pizza;

public class GreekStrasbourgPizza extends GreekPizza {
    public GreekStrasbourgPizza(){
        super();
        this.name += " (Strasbourg style)";
        this.toppings.add("olives");
    }
}
