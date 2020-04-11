package pizzas.impl;

import pizzas.Pizza;

public class CheeseStrasbourgPizza extends CheesePizza {
    public CheeseStrasbourgPizza(){
        super();
        this.name += " (Strasbourg style)";
        this.toppings.add("mushrooms");
    }
}
