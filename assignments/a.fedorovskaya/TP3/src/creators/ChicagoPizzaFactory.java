package creators;

import products.ChicagoCheesePizza;
import products.ChicagoPepperoniPizza;
import products.Pizza;

public class ChicagoPizzaFactory extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ChicagoCheesePizza();
        } else if(type.equals("pepperoni")){
            return new ChicagoPepperoniPizza();
        }
        return null;
    }
}
