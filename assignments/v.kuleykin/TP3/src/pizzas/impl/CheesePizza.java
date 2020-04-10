package pizzas.impl;

import pizzas.Pizza;

public class CheesePizza extends Pizza {
    public CheesePizza(){
        this.name = "Cheese pizza";
        this.toppings.add("mozzarella");
    }
}
