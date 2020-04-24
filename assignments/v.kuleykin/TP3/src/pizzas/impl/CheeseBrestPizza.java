package pizzas.impl;

import pizzas.Pizza;

public class CheeseBrestPizza extends CheesePizza {
    public CheeseBrestPizza(){
        super();
        this.name += " (Brest style)";
        this.toppings.add("chicken breast");
    }
}
