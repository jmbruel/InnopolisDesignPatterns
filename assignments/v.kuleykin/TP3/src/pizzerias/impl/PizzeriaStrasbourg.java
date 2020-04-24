package pizzerias.impl;

import pizzerias.Pizzeria;
import pizzas.Pizza;
import pizzas.impl.CheeseStrasbourgPizza;
import pizzas.impl.GreekStrasbourgPizza;

public class PizzeriaStrasbourg extends Pizzeria {

    @Override
    public Pizza createPizza(String type){
        switch (type){
            case "cheese": return new CheeseStrasbourgPizza();
            case "greek": return new GreekStrasbourgPizza();
            default: return null;
        }
    }
}
