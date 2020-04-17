package sites;

import menu.NYCheesePizza;
import menu.Pizza;

public class NYPizzaFactory extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYCheesePizza();
        }
        return null;
    }
}
