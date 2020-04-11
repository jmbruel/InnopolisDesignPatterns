package pizzerias.impl;

import pizzerias.Pizzeria;
import pizzas.Pizza;
import pizzas.impl.CheeseBrestPizza;
import pizzas.impl.GreekBrestPizza;

public class PizzeriaBrest extends Pizzeria {

    @Override
    public Pizza createPizza(String type){
        switch (type){
            case "cheese": return new CheeseBrestPizza();
            case "greek": return new GreekBrestPizza();
            default: return null;
        }
    }
}
