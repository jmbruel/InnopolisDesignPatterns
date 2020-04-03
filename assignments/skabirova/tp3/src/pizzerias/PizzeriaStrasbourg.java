package pizzerias;

import pizzas.CheeseStrasbourgPizza;
import pizzas.GreekStrasbourgPizza;
import pizzas.Pizza;

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
