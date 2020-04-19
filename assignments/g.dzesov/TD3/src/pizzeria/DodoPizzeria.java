package main.pizzeria;

import main.pizza.*;

public class DodoPizzeria extends Pizzeria {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("Hawaiian")){
            return new DodoHawaiianPizza();
        }
        else if(type.equals("Cheese")){
            return new DodoCheesePizza();
        }
        else{
            return new PlainPizza();
        }
    }
}