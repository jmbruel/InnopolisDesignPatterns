package pizzas.impl;

public class GreekBrestPizza extends GreekPizza {
    public GreekBrestPizza(){
        super();
        this.name += " (Brest style)";
        this.toppings.add("chicken brest");
    }
}
