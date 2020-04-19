package main.pizzeria;

import main.pizza.*;

public class PapaJohnsPizza extends Pizzeria {

    @Override
    Pizza createPizza(String type) {
        if(type.equals("pepperoni")){
            return new PapaJohnsPepperoniPizza();
        }
        else if(type.equals("kiwi")){
            return new PapaJohnsKiwiPizza();
        }
        else{
            return new DefaultPizza();
        }
    }
}
