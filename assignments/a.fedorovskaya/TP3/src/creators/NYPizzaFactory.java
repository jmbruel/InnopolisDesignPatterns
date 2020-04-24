package creators;

import products.NYCheesePizza;
import products.NYPepperoniPizza;
import products.Pizza;

public class NYPizzaFactory extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYCheesePizza();
        } else if(type.equals("pepperoni")){
            return new NYPepperoniPizza();
        }
        return null;
    }
}
