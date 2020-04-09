package sites;

import menu.ItlaianCheesePizza;
import menu.Pizza;

public class ItalianPizzaFactory extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ItlaianCheesePizza();
        }
        return null;
    }
}
