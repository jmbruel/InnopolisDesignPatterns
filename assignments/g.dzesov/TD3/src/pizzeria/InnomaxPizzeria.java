package main.pizzeria;

import main.pizza.*;

public class InnomaxPizzeria extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("Hawaiian")){
            return new InnomaxHawaiianPizza();
        }
        else if(type.equals("Cheese")){
            return new InnomaxCheesePizza();
        }
        else{
            return new PlainPizza();
        }
    }
}