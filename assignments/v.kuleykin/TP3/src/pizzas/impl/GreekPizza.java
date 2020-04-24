package pizzas.impl;

import pizzas.Pizza;

public class GreekPizza extends Pizza {
    public GreekPizza(){
        this.name = "Greek Brest";
        this.toppings.add("mozzarella");
        this.toppings.add("feta");
    }
}
